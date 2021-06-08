package atomicstryker.ic2.advancedmachines.data;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemAdvancedMachine extends ItemBlock {
	public ItemAdvancedMachine(Block b) {
		super(b);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean bool) {
		int meta = stack.getItemDamage();
		if (meta == 4) {
			info.add("Power" + " " + "16 EU/t" + ", " + "32 EU/t " + StatCollector.translateToLocal("ic2.item.tooltip.max"));
		} else if (meta == 3) {
			info.add("Power" + " " + "3 EU/t" + ", " + "128 EU/t " + StatCollector.translateToLocal("ic2.item.tooltip.max"));
		} else {
			info.add("Power" + " " + "6 EU/t" + ", " + "128 EU/t " + StatCollector.translateToLocal("ic2.item.tooltip.max"));
		}
	}

	@Override
	public int getMetadata(int var1) {
		return var1;
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.uncommon;
	}

	@Override
	public String getUnlocalizedName(ItemStack var1) {
		int var2 = var1.getItemDamage();
		switch (var2) {
		case 0:
			return "item.advancedmachines:rotaryMacerator";
		case 1:
			return "item.advancedmachines:singularityCompressor";
		case 2:
			return "item.advancedmachines:centrifugeExtractor";
		case 3:
			return "item.advancedmachines:combinedRecycler";
		case 4:
			return "item.advancedmachines:rotaryOreWasher";
		default:
			return null;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
		par3List.add(new ItemStack(par1, 1, 3));
		par3List.add(new ItemStack(par1, 1, 4));
	}
}
