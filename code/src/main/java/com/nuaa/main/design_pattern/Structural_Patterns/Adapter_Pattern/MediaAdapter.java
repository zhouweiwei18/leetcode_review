package com.nuaa.main.design_pattern.Structural_Patterns.Adapter_Pattern;

import com.nuaa.main.design_pattern.Structural_Patterns.Adapter_Pattern.impl.Mp4Player;
import com.nuaa.main.design_pattern.Structural_Patterns.Adapter_Pattern.impl.VlcPlayer;
import com.nuaa.main.design_pattern.Structural_Patterns.Adapter_Pattern.mapper.AdvancedMediaPlayer;
import com.nuaa.main.design_pattern.Structural_Patterns.Adapter_Pattern.mapper.MediaPlayer;

public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}