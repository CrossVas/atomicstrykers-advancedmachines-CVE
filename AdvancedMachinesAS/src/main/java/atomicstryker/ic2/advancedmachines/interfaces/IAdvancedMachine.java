package atomicstryker.ic2.advancedmachines.interfaces;

import ic2.core.block.invslot.InvSlotOutput;

import java.util.ArrayList;

public interface IAdvancedMachine {

	String printFormattedData();

	int getSpeed();

	void setClientSpeed(int value);

	ArrayList<InvSlotOutput> getOutputSlots();

}
