/**
 *
 */
package cn.hello.jay.practice.design.structural_patterns.adapter_pattern;

/**
 * 3. 创建实现了 MediaPlayer 接口的适配器类
 *
 * @author 周健以
 * @Date 2019年02月26日
 */
public class MediaAdapter implements MediaPlayer {

    public static final String VLC = "vlc";
    public static final String MP4 = "mp4";

    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (VLC.equalsIgnoreCase(audioType)) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (MP4.equalsIgnoreCase(audioType)) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String filename) {
        if (VLC.equalsIgnoreCase(audioType)) {
            advancedMediaPlayer.playVlc(filename);
        } else if (MP4.equalsIgnoreCase(audioType)) {
            advancedMediaPlayer.playVlc(audioType);
        }
    }
}
