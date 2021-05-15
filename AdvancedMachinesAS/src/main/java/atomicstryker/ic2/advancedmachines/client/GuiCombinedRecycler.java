package atomicstryker.ic2.advancedmachines.client;

import ic2.core.block.machine.tileentity.TileEntityStandardMachine;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import atomicstryker.ic2.advancedmachines.ContainerAdvancedMachine;
import atomicstryker.ic2.advancedmachines.IAdvancedMachine;
import atomicstryker.ic2.advancedmachines.TileEntityAdvancedRecycler;

public class GuiCombinedRecycler extends GuiContainer {
	private static ResourceLocation tex = new ResourceLocation("advancedmachines",
			"textures/gui/GUICombinedRecycler.png");

	private ContainerAdvancedMachine<TileEntityStandardMachine> container;

	public GuiCombinedRecycler(ContainerAdvancedMachine<TileEntityStandardMachine> csm, TileEntityAdvancedRecycler te) {
		super(csm);
		container = csm;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRendererObj.drawString(StatCollector.translateToLocal("item.advancedmachines:combinedRecycler.name"),
				8, 6, 4210752);
		this.fontRendererObj.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);
		this.fontRendererObj.drawString("Mass rate:", 8, 36, 4210752);
		this.fontRendererObj.drawString(((IAdvancedMachine) container.base).printFormattedData(), 10, 44, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(tex);
		int j = (this.width - this.xSize) / 2;
		int k = (this.height - this.ySize) / 2;
		drawTexturedModalRect(j, k, 0, 0, this.xSize, this.ySize);

		int chargeLevel = (int) (14.0F * ((TileEntityStandardMachine) container.base).getChargeLevel());
		int progress = (int) (24.0F * ((TileEntityStandardMachine) container.base).getProgress());

		if (chargeLevel > 0)
			drawTexturedModalRect(j + 56, k + 36 + 14 - chargeLevel, 176, 14 - chargeLevel, 14, chargeLevel);
		if (progress > 0)
			drawTexturedModalRect(j + 79, k + 34, 176, 14, progress + 1, 16);
	}
}
