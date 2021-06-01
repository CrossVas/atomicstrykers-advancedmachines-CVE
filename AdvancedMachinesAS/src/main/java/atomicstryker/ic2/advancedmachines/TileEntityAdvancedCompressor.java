package atomicstryker.ic2.advancedmachines;

import ic2.api.recipe.RecipeOutput;
import ic2.api.recipe.Recipes;
import ic2.core.BasicMachineRecipeManager;
import ic2.core.block.comp.Redstone;
import ic2.core.block.invslot.InvSlotOutput;
import ic2.core.block.invslot.InvSlotProcessableGeneric;
import ic2.core.block.machine.tileentity.TileEntityStandardMachine;
import ic2.core.upgrade.UpgradableProperty;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.Map.Entry;

import atomicstryker.ic2.advancedmachines.client.GuiSingularityCompressor;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityAdvancedCompressor extends TileEntityStandardMachine implements IAdvancedMachine, IRedstoneUpgrade {

	private final CommonLogicAdvancedMachines advLogic;
	private Redstone redstone;
	public static List<Entry<ItemStack, ItemStack>> recipes = new Vector();

	public TileEntityAdvancedCompressor() {
		super(6, 900, 1, 2);
		advLogic = new CommonLogicAdvancedMachines("%6d PSI", 10);
		advLogic.getOutputSlots().add(outputSlot);
		this.redstone = addComponent(new Redstone(this));
		this.inputSlot = new InvSlotProcessableGeneric(this, "input", 0, 1, Recipes.compressor);
	}
	
	public static void init() {
		Recipes.compressor = new BasicMachineRecipeManager();
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtt) {
		super.readFromNBT(nbtt);
		advLogic.readFromNBT(nbtt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtt) {
		super.writeToNBT(nbtt);
		advLogic.writeToNBT(nbtt);
	}

	@Override
	public void updateEntityServer() {
		super.updateEntityServer();
		advLogic.updateEntity(this);
	}

	@Override
	public void setOverclockRates() {
		super.setOverclockRates();
		advLogic.setOverclockRates(this);
	}

	@Override
	public RecipeOutput getOutput() {
		return advLogic.getOutput(this);
	}

	@Override
	public void operateOnce(RecipeOutput output, List<ItemStack> processResult) {
		advLogic.operateOnce(this, output, processResult);
	}

	@Override
	public String printFormattedData() {
		return advLogic.printFormattedData();
	}

	@Override
	public int getSpeed() {
		return advLogic.getSpeed();
	}

	@Override
	public void setClientSpeed(int value) {
		advLogic.setClientSpeed(value);
	}

	@Override
	public ArrayList<InvSlotOutput> getOutputSlots() {
		return advLogic.getOutputSlots();
	}

	@Override
	public Set<UpgradableProperty> getUpgradableProperties() {
		return EnumSet.of(UpgradableProperty.RedstoneSensitive, UpgradableProperty.ItemConsuming,
				UpgradableProperty.ItemProducing);
	}
	
	@Override
	public boolean hasRedstoneUpgrade() {
		return this.redstone.hasRedstoneInput();
	}
	
	@Override
	public GuiScreen getGui(EntityPlayer player, boolean var2) {
		return new GuiSingularityCompressor(new ContainerAdvancedMachine<TileEntityStandardMachine>(player, this), this);
	}

	@Override
	public String getInventoryName() {
		return "Singularity Compressor";
	}
}
