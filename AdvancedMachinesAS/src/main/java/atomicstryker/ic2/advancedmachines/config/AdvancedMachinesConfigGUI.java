package atomicstryker.ic2.advancedmachines.config;

import static atomicstryker.ic2.advancedmachines.config.AdvancedMachinesConfig.config;

import java.util.ArrayList;
import java.util.List;

import atomicstryker.ic2.advancedmachines.config.AdvancedMachinesConfig.AdvancedMachinesConfigCategory;
import atomicstryker.ic2.advancedmachines.utils.References;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.ConfigElement;

public class AdvancedMachinesConfigGUI extends GuiConfig {

	public AdvancedMachinesConfigGUI(GuiScreen guiScreen) {
		super(guiScreen, getConfigElements(guiScreen), References.MOD_ID, false, false,
				References.MOD_NAME + " - " + "Config");
	}

	public static List<IConfigElement> getConfigElements(GuiScreen guiScreen) {
		List<IConfigElement> list = new ArrayList<IConfigElement>();
		for (AdvancedMachinesConfigCategory category : AdvancedMachinesConfig.configCategories) {
			list.add(new ConfigElement<ConfigCategory>(config.getCategory(category.name.toLowerCase())));
		}
		return list;
	}
}
