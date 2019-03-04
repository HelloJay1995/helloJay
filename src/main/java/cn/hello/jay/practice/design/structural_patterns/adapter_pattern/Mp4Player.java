/**
 *
 */
package cn.hello.jay.practice.design.structural_patterns.adapter_pattern;

/**
 * @author 周健以
 * @Date 2019年02月26日
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
