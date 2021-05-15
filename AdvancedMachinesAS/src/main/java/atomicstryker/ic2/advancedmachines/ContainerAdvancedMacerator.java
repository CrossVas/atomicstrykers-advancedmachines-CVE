package atomicstryker.ic2.advancedmachines;

import ic2.core.block.machine.tileentity.TileEntityStandardMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerAdvancedMacerator extends ContainerAdvancedMachine<TileEntityStandardMachine> {

	private final TileEntityAdvancedMacerator advMacerator;

	public ContainerAdvancedMacerator(EntityPlayer entityPlayer, TileEntityAdvancedMacerator tileEntity) {
		super(entityPlayer, tileEntity);
		advMacerator = tileEntity;

		/** Maceration Suppliment Slot */
		addSlotToContainer(new Slot(tileEntity, TileEntityAdvancedMacerator.SUPPLEMENT_SLOT_INDEX, 75, 17));
	}

	@Override
	public ItemStack slotClick(int slotIndex, int j, int flag, EntityPlayer entityplayer) {
		if (slotIndex == TileEntityAdvancedMacerator.SUPPLEMENT_SLOT_INDEX) {
			ItemStack slotItem = ((Slot) this.inventorySlots.get(TileEntityAdvancedMacerator.SUPPLEMENT_SLOT_INDEX))
					.getStack();
			if (slotItem != null && advMacerator.supplementedItemsLeft != 0) {
				slotItem.stackSize--;
				if (slotItem.stackSize < 1) {
					((Slot) this.inventorySlots.get(TileEntityAdvancedMacerator.SUPPLEMENT_SLOT_INDEX)).putStack(null);
				}
				advMacerator.supplementedItemsLeft = 0;
			}
		}

		return super.slotClick(slotIndex, j, flag, entityplayer);
	}

}
