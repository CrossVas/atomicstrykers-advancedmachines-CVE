package atomicstryker.ic2.advancedmachines.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import atomicstryker.ic2.advancedmachines.utils.References;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class AdvancedMachinesConfig {

	public static Configuration config;
	
	public static int maxMachineSpeedUpFactor 	= 10;
	public static int maxMachineSpeedUpTicks 	= 10000;
	public static double machinePowerDrawFactor = 3.0D;
	
	public static boolean enableRotaryMaceratorRecipe 		= true;
	public static boolean enableSingularityCompressorRecipe = true;
	public static boolean enableCentrifugeExtractorRecipe 	= true;
	public static boolean enableCombinedRecyclerRecipe 		= true;
	public static boolean enableRotaryOreWasherRecipe 		= true;
	
	public static void init(String configDirectory) {
		if (config == null) {
			File configPath = new File(configDirectory + "/" + References.MOD_ID + ".cfg");
			config = new Configuration(configPath);
			loadConfig();
		}
	}
	
	public static void loadConfig() {
		
		maxMachineSpeedUpFactor = config.getInt("Machines Speed Up Factor", stats.name, maxMachineSpeedUpFactor, 1, 10, "Advanced Machines will reach X times the speed of normal machines");
		maxMachineSpeedUpTicks 	= config.getInt("Machines Speed Up Ticks", stats.name, maxMachineSpeedUpTicks, 1, 10000, "Advanced Machines will take X ingame ticks to reach max speed");
		machinePowerDrawFactor 	= config.getFloat("Machines Power Draw Factor", stats.name, (float) machinePowerDrawFactor, 1, (float) 3.0D, "Advanced Machines will draw X times the normal machines power");
		
		enableRotaryMaceratorRecipe 		= config.getBoolean("Rotary Macerator", recipes.name, enableRotaryMaceratorRecipe, "Disable Rotary Macerator Recipe");
		enableSingularityCompressorRecipe 	= config.getBoolean("Singularity Compressor", recipes.name, enableSingularityCompressorRecipe, "Disable Singularity Compressor Recipe");
		enableCentrifugeExtractorRecipe 	= config.getBoolean("Centrifuge Extractor", recipes.name, enableCentrifugeExtractorRecipe, "Disable Centrifuge Extractor Recipe");
		enableCombinedRecyclerRecipe 		= config.getBoolean("Combined Recycler", recipes.name, enableCombinedRecyclerRecipe, "Disable Combined Recycler Receipe");
		enableRotaryOreWasherRecipe 		= config.getBoolean("Rotary Ore Washer", recipes.name, enableRotaryOreWasherRecipe, "Disable Rotary Ore Washer Recipe");
		
		if (config.hasChanged()) config.save();
	}
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.modID.equalsIgnoreCase(References.MOD_ID)) {
			loadConfig();
		}
	}
	
	public static final List<AdvancedMachinesConfigCategory> configCategories;
	
	static {
		configCategories = new ArrayList<AdvancedMachinesConfigCategory>();
	}
	
	public static class AdvancedMachinesConfigCategory {
		public String name;
		public AdvancedMachinesConfigCategory(String name) {
			this.name = name;
			registerCategory();
		}
		
		public void registerCategory() {
			configCategories.add(this);
		}
	}
	
	public static final AdvancedMachinesConfigCategory recipes = new AdvancedMachinesConfigCategory("Recipes Settings");
	public static final AdvancedMachinesConfigCategory stats = new AdvancedMachinesConfigCategory("Machines Stats");
}
