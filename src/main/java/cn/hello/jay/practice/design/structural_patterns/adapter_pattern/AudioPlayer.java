/**
 *
 */
package cn.hello.jay.practice.design.structural_patterns.adapter_pattern;

/**
 * 4. 创建实现了 MediaPlayer 接口的实体类。
 *
 * @author 周健以
 * @Date 2019年02月26日
 */
public class AudioPlayer implements MediaPlayer {

    public static final String MP3 = "mp3";

    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String filename) {
        // 播放 MP3 音乐文件的内置支持
        if (MP3.equalsIgnoreCase(audioType)) {
            System.out.println("Playing mp3 file. Name: " + filename);
        } // mediaAdapter 提供了其他文件格式的支持
        else if (audioType.equalsIgnoreCase(MediaAdapter.VLC) || audioType.equalsIgnoreCase(MediaAdapter.MP4)) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, filename);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
