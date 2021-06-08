package atomicstryker.ic2.advancedmachines;

import atomicstryker.ic2.advancedmachines.config.AdvancedMachinesConfig;
import atomicstryker.ic2.advancedmachines.utils.IdentRecipe;
import ic2.api.item.IC2Items;
import ic2.api.recipe.Recipes;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class AdvancedMachinesRecipes {

	static AdvancedMachinesData data;
	
	public static void initRecipes() {
		if (AdvancedMachinesConfig.enableRotaryMaceratorRecipe) {
			Recipes.advRecipes.addRecipe(data.stackRotaryMacerator,
					new Object[] { "CRC", "PMP", "PAP", Character.valueOf('C'), IC2Items.getItem("coil"),
							Character.valueOf('R'), IC2Items.getItem("elemotor"), Character.valueOf('P'), "plateIron",
							Character.valueOf('M'), IC2Items.getItem("macerator"), Character.valueOf('A'),
							IC2Items.getItem("advancedMachine") });
		}

		/** ident recipes for my supplemented specialties */
		Recipes.macerator.addRecipe(new IdentRecipe(new ItemStack(Blocks.netherrack)), new NBTTagCompound(),
				new ItemStack(Blocks.netherrack));
		Recipes.macerator.addRecipe(new IdentRecipe(new ItemStack(Blocks.quartz_ore)), new NBTTagCompound(),
				new ItemStack(Blocks.quartz_ore));

		if (AdvancedMachinesConfig.enableSingularityCompressorRecipe) {
			Recipes.advRecipes.addRecipe(data.stackSingularityCompressor,
					new Object[] { "RGR", "MMM", "PAP", Character.valueOf('R'), Blocks.obsidian, Character.valueOf('G'),
							IC2Items.getItem("reinforcedGlass"), Character.valueOf('P'), "plateIron",
							Character.valueOf('M'), IC2Items.getItem("compressor"), Character.valueOf('A'),
							IC2Items.getItem("advancedMachine") });
		}

		if (AdvancedMachinesConfig.enableCentrifugeExtractorRecipe) {
			Recipes.advRecipes.addRecipe(data.stackCentrifugeExtractor,
					new Object[] { "CEC", "RMR", "PAP", Character.valueOf('C'), IC2Items.getItem("coil"),
							Character.valueOf('E'), IC2Items.getItem("elemotor"), Character.valueOf('R'),
							IC2Items.getItem("electrolyzedWaterCell"), Character.valueOf('P'), "plateIron",
							Character.valueOf('M'), IC2Items.getItem("extractor"), Character.valueOf('A'),
							IC2Items.getItem("advancedMachine") });
		}

		if (AdvancedMachinesConfig.enableCombinedRecyclerRecipe) {
			Recipes.advRecipes.addRecipe(data.stackCombinedRecycler,
					new Object[] { " M ", "PEP", "PRP", Character.valueOf('M'), data.stackRotaryMacerator,
							Character.valueOf('E'), data.stackCentrifugeExtractor, Character.valueOf('P'), "plateIron",
							Character.valueOf('R'), IC2Items.getItem("recycler") });
		}

		if (AdvancedMachinesConfig.enableRotaryOreWasherRecipe) {
			Recipes.advRecipes.addRecipe(data.stackRotaryOreWasher,
					new Object[] { "CRC", "PWP", "PAP", Character.valueOf('C'), IC2Items.getItem("coil"),
							Character.valueOf('R'), IC2Items.getItem("elemotor"), Character.valueOf('P'), "plateIron",
							Character.valueOf('W'), IC2Items.getItem("orewashingplant"), Character.valueOf('A'),
							IC2Items.getItem("advancedMachine") });
		}
	}
	
}
