package my.chimera.ui.gui;

import my.chimera.Client;
import my.chimera.ui.font.FontLoaders;
import my.chimera.ui.jelloparticle.ParticleEngine;
import my.chimera.util.render.RenderUtil;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.Display;

import java.awt.*;

public class GuiBaned extends GuiScreen {
    public ParticleEngine pe = new ParticleEngine(new Color(255,0,0));
    @Override
    public void initGui(){

    }
    @Override
    protected void keyTyped(char var1, int var2) {

    }
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        Display.setTitle(Client.name + " " + Client.chimeraVersion + " | 请联系客服申诉! Locked! 已锁定!");
        ScaledResolution sr = new ScaledResolution(mc);
        int h = new ScaledResolution(this.mc).getScaledHeight();
        int w = new ScaledResolution(this.mc).getScaledWidth();
        Gui.drawRect(-20, -20, w + 20, h + 20, new Color(0, 0, 0).getRGB());
        this.drawGradientRect(0, 0, w, h, new Color(0, 0, 0, 0).getRGB(), new Color(255, 0, 0, 180).getRGB());
        pe.render(0, 0);
        RenderUtil.drawImage(new ResourceLocation("Distance/Lock.png"), w / 2 - 50, h / 2 - 90, 100, 100);
        FontLoaders.calibrilite32.drawCenteredString("Your Chimera has been locked!", w / 2f, h / 2f + 20, -1);
        Client.FontLoaders.Chinese18.drawCenteredString("你的Chimera已被锁定!", w / 2f, h / 2f + 40, -1);
        FontLoaders.GoogleSans16.drawCenteredString(Client.name + " made by \u00a7oMymylesaws\u00a7r (Chimera Team)", width / 2f, height - FontLoaders.GoogleSans16.getHeight() - 6f, -1);

    }
}
