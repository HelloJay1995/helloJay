/**
 *
 */
package cn.hello.jay.practice.design.structural_patterns.adapter_pattern;

/**
 * 1. 为媒体播放器创建接口。
 *
 * @author 周健以
 * @Date 2019年02月26日
 */
public interface MediaPlayer {

    /**
     * 播放视频
     *
     * @param audioType
     * @param filename
     */
    void play(String audioType, String filename);
}
