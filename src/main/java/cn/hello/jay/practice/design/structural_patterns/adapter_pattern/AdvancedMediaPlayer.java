/**
 *
 */
package cn.hello.jay.practice.design.structural_patterns.adapter_pattern;

/**
 * 1. 为更高级的媒体播放器创建接口。
 *
 * @author 周健以
 * @Date 2019年02月26日
 */
public interface AdvancedMediaPlayer {

    /**
     * 播放Vlc视屏格式
     */
    void playVlc(String fileName);

    /**
     * 播放Mp4视屏格式
     */
    void playMp4(String fileName);
}
