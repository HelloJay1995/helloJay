package cn.hello.jay.practice.design.structural_patterns.proxy_pattern;

/**
 * @author 周健以
 * @Date 2019年03月27日
 */
public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
