package my.chimera.module.modules.render;

import my.chimera.api.EventHandler;
import my.chimera.api.events.Render.EventRender2D;
import my.chimera.api.value.Numbers;
import my.chimera.api.value.Option;
import my.chimera.module.Module;
import my.chimera.module.ModuleType;

import java.awt.*;

public class EnchantEffect extends Module {
    public static float hue = 0.0F;
    public static Numbers<Double> r = new Numbers<>("Red", 255d, 0d, 255d, 1d);
    public static Numbers<Double> g = new Numbers<>("Green", 0d, 0d, 255d, 1d);
    public static Numbers<Double> b = new Numbers<>("Blue", 0d, 0d, 255d, 1d);
    public static Option Rainbow = new Option("Rainbow", false);

    public EnchantEffect() {
        super("EnchantEffect", new String[]{"EnchantColor"}, ModuleType.Render);
        addValues(r, g, b, Rainbow);
    }

    @EventHandler
    public void Render2d(EventRender2D e) {
        hue += HUD.RainbowSpeed.getValue().floatValue() / 5.0F;
        if (hue > 255.0F) {
            hue = 0.0F;
        }
    }

    public static Color getEnchantColor() {
        if (Rainbow.getValue()) {
            return Color.getHSBColor(hue / 255f, 0.75f, 0.9f);
        } else {
            return new Color(r.getValue().intValue(), g.getValue().intValue(), b.getValue().intValue());
        }
    }
}
