package cn.hello.jay.practice.design.structural_patterns.proxy_pattern;

/**
 * 2.
 *
 * @author 周健以
 * @Date 2019年03月27日
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String filename) {
        System.out.println("Loading " + filename);
    }


    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
