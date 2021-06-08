package atomicstryker.ic2.advancedmachines;

import ic2.core.block.machine.container.ContainerOreWashing;
import ic2.core.block.machine.tileentity.TileEntityOreWashing;
import ic2.core.block.machine.tileentity.TileEntityStandardMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import atomicstryker.ic2.advancedmachines.container.ContainerAdvancedMacerator;
import atomicstryker.ic2.advancedmachines.container.ContainerAdvancedMachine;
import atomicstryker.ic2.advancedmachines.gui.GuiCentrifugeExtractor;
import atomicstryker.ic2.advancedmachines.gui.GuiCombinedRecycler;
import atomicstryker.ic2.advancedmachines.gui.GuiRotaryMacerator;
import atomicstryker.ic2.advancedmachines.gui.GuiRotaryOreWasher;
import atomicstryker.ic2.advancedmachines.gui.GuiSingularityCompressor;
import atomicstryker.ic2.advancedmachines.interfaces.IProxy;
import atomicstryker.ic2.advancedmachines.tiles.TileEntityAdvancedCompressor;
import atomicstryker.ic2.advancedmachines.tiles.TileEntityAdvancedExtractor;
import atomicstryker.ic2.advancedmachines.tiles.TileEntityAdvancedMacerator;
import atomicstryker.ic2.advancedmachines.tiles.TileEntityAdvancedOreWasher;
import atomicstryker.ic2.advancedmachines.tiles.TileEntityAdvancedRecycler;

public class AdvancedMachinesClient implements IProxy {
	public static int[][] sideAndFacingToSpriteOffset;

	@Override
	public void load() {
		try {
			sideAndFacingToSpriteOffset = (int[][]) Class.forName("ic2.core.block.BlockMultiID")
					.getField("sideAndFacingToSpriteOffset").get(null);
		} catch (Exception e) {
			sideAndFacingToSpriteOffset = new int[][] { { 3, 2, 0, 0, 0, 0 }, { 2, 3, 1, 1, 1, 1 },
					{ 1, 1, 3, 2, 5, 4 }, { 0, 0, 2, 3, 4, 5 }, { 4, 5, 4, 5, 3, 2 }, { 5, 4, 5, 4, 2, 3 } };
		}
	}

	@Override
	public Object getGuiElementForClient(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null) {
			if (te instanceof TileEntityAdvancedMacerator) {
				return new GuiRotaryMacerator(new ContainerAdvancedMacerator(player, (TileEntityAdvancedMacerator) te),
						(TileEntityAdvancedMacerator) te);
			} else if (te instanceof TileEntityAdvancedExtractor) {
				return new GuiCentrifugeExtractor(new ContainerAdvancedMachine<TileEntityStandardMachine>(player,
						(TileEntityAdvancedExtractor) te), (TileEntityAdvancedExtractor) te);
			} else if (te instanceof TileEntityAdvancedCompressor) {
				return new GuiSingularityCompressor(new ContainerAdvancedMachine<TileEntityStandardMachine>(player,
						(TileEntityAdvancedCompressor) te), (TileEntityAdvancedCompressor) te);
			} else if (te instanceof TileEntityAdvancedRecycler) {
				return new GuiCombinedRecycler(new ContainerAdvancedMachine<TileEntityStandardMachine>(player,
						(TileEntityAdvancedRecycler) te), (TileEntityAdvancedRecycler) te);
			} else if (te instanceof TileEntityAdvancedOreWasher) {
				return new GuiRotaryOreWasher(new ContainerOreWashing(player, (TileEntityOreWashing) te),
						(TileEntityOreWashing) te);
			}
		}

		return null;
	}

}
