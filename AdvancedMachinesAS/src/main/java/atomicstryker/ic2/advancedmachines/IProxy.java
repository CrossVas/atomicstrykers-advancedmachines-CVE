package atomicstryker.ic2.advancedmachines;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public interface IProxy {
	public void load();

	public Object getGuiElementForClient(int ID, EntityPlayer player, World world, int x, int y, int z);
}
