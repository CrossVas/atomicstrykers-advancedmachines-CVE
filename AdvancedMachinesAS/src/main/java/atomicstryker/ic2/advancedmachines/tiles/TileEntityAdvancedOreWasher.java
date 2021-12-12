package atomicstryker.ic2.advancedmachines.tiles;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import atomicstryker.ic2.advancedmachines.interfaces.IAdvancedMachine;
import atomicstryker.ic2.advancedmachines.interfaces.IRedstoneUpgrade;
import atomicstryker.ic2.advancedmachines.utils.CommonLogicAdvancedMachines;
import ic2.api.recipe.RecipeOutput;
import ic2.core.block.comp.Redstone;
import ic2.core.block.invslot.InvSlotOutput;
import ic2.core.block.machine.tileentity.TileEntityOreWashing;
import ic2.core.upgrade.UpgradableProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityAdvancedOreWasher extends TileEntityOreWashing implements IAdvancedMachine, IRedstoneUpgrade {

	private final CommonLogicAdvancedMachines advLogic;
	private Redstone redstone;

	public TileEntityAdvancedOreWasher() {
		super();
		advLogic = new CommonLogicAdvancedMachines("%5d RPM", 1);
		advLogic.getOutputSlots().add(outputSlot);
		this.redstone = addComponent(new Redstone(this));
	}

	@Override
	public int getSinkTier() {
		return 2;
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
		fluidTank.drain(output.metadata.getInteger("amount"), true);
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
}
