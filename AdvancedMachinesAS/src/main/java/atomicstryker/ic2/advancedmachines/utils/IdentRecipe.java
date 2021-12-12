package atomicstryker.ic2.advancedmachines.utils;

import java.util.ArrayList;
import java.util.List;

import ic2.api.recipe.IRecipeInput;
import net.minecraft.item.ItemStack;

public class IdentRecipe implements IRecipeInput {

	/**
	 * matches will return false ONCE to get past the input == output check Player
	 * so thoughtfully added
	 */

	boolean registerHackActive;
	private ArrayList<ItemStack> inputresult;

	public IdentRecipe(ItemStack toProcess) {
		inputresult = new ArrayList<ItemStack>();
		inputresult.add(toProcess);
		registerHackActive = true;
	}

	@Override
	public int getAmount() {
		return 1;
	}

	@Override
	public List<ItemStack> getInputs() {
		return inputresult;
	}

	@Override
	public boolean matches(ItemStack itemStack) {
		if (registerHackActive) {
			registerHackActive = false;
			return false;
		}
		return inputresult.get(0).isItemEqual(itemStack);
	}
}
