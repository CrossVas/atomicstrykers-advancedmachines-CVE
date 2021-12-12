package atomicstryker.ic2.advancedmachines;

import atomicstryker.ic2.advancedmachines.data.BlockAdvancedMachines;
import atomicstryker.ic2.advancedmachines.data.ItemAdvancedMachine;
import atomicstryker.ic2.advancedmachines.tiles.TileEntityAdvancedCompressor;
import atomicstryker.ic2.advancedmachines.tiles.TileEntityAdvancedExtractor;
import atomicstryker.ic2.advancedmachines.tiles.TileEntityAdvancedMacerator;
import atomicstryker.ic2.advancedmachines.tiles.TileEntityAdvancedOreWasher;
import atomicstryker.ic2.advancedmachines.tiles.TileEntityAdvancedRecycler;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.core.IC2;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class AdvancedMachinesData {

	public static Block blockAdvancedMachine;
	public static ItemStack stackRotaryMacerator;
	public static ItemStack stackSingularityCompressor;
	public static ItemStack stackCentrifugeExtractor;
	public static ItemStack stackCombinedRecycler;
	public static ItemStack stackRotaryOreWasher;

	public static void preInitData() {
		blockAdvancedMachine = new BlockAdvancedMachines();
		blockAdvancedMachine.setCreativeTab(IC2.tabIC2);

		GameRegistry.registerBlock(blockAdvancedMachine, ItemAdvancedMachine.class, "blockAdvMachine");

		stackRotaryMacerator = new ItemStack(blockAdvancedMachine, 1, 0);
		stackSingularityCompressor = new ItemStack(blockAdvancedMachine, 1, 1);
		stackCentrifugeExtractor = new ItemStack(blockAdvancedMachine, 1, 2);
		stackCombinedRecycler = new ItemStack(blockAdvancedMachine, 1, 3);
		stackRotaryOreWasher = new ItemStack(blockAdvancedMachine, 1, 4);
	}

	public static void initData() {
		GameRegistry.registerTileEntity(TileEntityAdvancedMacerator.class, "Rotary Macerator");
		GameRegistry.registerTileEntity(TileEntityAdvancedCompressor.class, "Singularity Compressor");
		GameRegistry.registerTileEntity(TileEntityAdvancedExtractor.class, "Centrifuge Extractor");
		GameRegistry.registerTileEntity(TileEntityAdvancedRecycler.class, "Combined Recycler");
		GameRegistry.registerTileEntity(TileEntityAdvancedOreWasher.class, "Rotary Ore Washer");
	}
}
