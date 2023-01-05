package my.chimera.module.modules.world;

import my.chimera.api.value.Numbers;
import my.chimera.module.Module;
import my.chimera.module.ModuleType;
import my.chimera.ui.cloudmusic.ui.GuiCloudMusic;

public class MusicPlayer extends Module {
    public static final Numbers<Double> musicPosYlyr = new Numbers<>("MusicPlayerLyricY", 120d, 0d, 200d, 1d);
    public MusicPlayer() {
        super("MusicPlayer",new String[]{"neteasemusicplayer","music"}, ModuleType.World);
        addValues(musicPosYlyr);
    }

    @Override
    public void onEnable(){
        mc.displayGuiScreen(new GuiCloudMusic());
        this.setEnabled(false);
    }
}
