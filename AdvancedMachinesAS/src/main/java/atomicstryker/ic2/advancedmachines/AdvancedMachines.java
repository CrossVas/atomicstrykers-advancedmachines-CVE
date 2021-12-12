package atomicstryker.ic2.advancedmachines;

import atomicstryker.ic2.advancedmachines.config.AdvancedMachinesConfig;
import atomicstryker.ic2.advancedmachines.container.ContainerAdvancedMacerator;
import atomicstryker.ic2.advancedmachines.container.ContainerAdvancedMachine;
import atomicstryker.ic2.advancedmachines.interfaces.IProxy;
import atomicstryker.ic2.advancedmachines.tiles.TileEntityAdvancedMacerator;
import atomicstryker.ic2.advancedmachines.tiles.TileEntityAdvancedOreWasher;
import atomicstryker.ic2.advancedmachines.utils.References;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import ic2.core.block.machine.container.ContainerOreWashing;
import ic2.core.block.machine.tileentity.TileEntityOreWashing;
import ic2.core.block.machine.tileentity.TileEntityStandardMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.MOD_VER, dependencies = References.MOD_DEPS, acceptedMinecraftVersions = References.MC_VER, guiFactory = References.GUI_FACTORY)
public class AdvancedMachines implements IGuiHandler, IProxy {

	@SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.SERVER_PROXY)
	public static IProxy proxy;

	@Instance(value = References.MOD_ID)
	public static AdvancedMachines instance;

	static AdvancedMachinesData data;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		AdvancedMachinesConfig.init(event.getModConfigurationDirectory().toString());
		FMLCommonHandler.instance().bus().register(new AdvancedMachinesConfig());
		AdvancedMachinesData.preInitData();
	}

	@EventHandler
	public void load(FMLInitializationEvent evt) {
		AdvancedMachinesData.initData();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, this);
		proxy.load();
	}

	@EventHandler
	public void afterModsLoaded(FMLPostInitializationEvent evt) {
		AdvancedMachinesRecipes.initRecipes();
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntityStandardMachine tesm = (TileEntityStandardMachine) world.getTileEntity(x, y, z);
		if (tesm != null) {
			if (tesm instanceof TileEntityAdvancedMacerator) {
				return new ContainerAdvancedMacerator(player, (TileEntityAdvancedMacerator) tesm);
			} else if (tesm instanceof TileEntityAdvancedOreWasher) {
				return new ContainerOreWashing(player, (TileEntityOreWashing) tesm);
			}

			return new ContainerAdvancedMachine<TileEntityStandardMachine>(player, tesm);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return proxy.getGuiElementForClient(ID, player, world, x, y, z);
	}

	@Override
	public void load() {
	}

	@Override
	public Object getGuiElementForClient(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
}
