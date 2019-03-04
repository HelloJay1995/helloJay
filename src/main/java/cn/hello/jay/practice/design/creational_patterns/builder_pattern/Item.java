/**
 *
 */
package cn.hello.jay.practice.design.creational_patterns.builder_pattern;

/**
 * 创建一个表示食物条目和食物包装的接口
 *
 * @author 周健以
 * @Date 2019年02月22日
 */
public interface Item {

    /**
     * 名称
     *
     * @return
     */
    public String name();

    /**
     * 包装
     *
     * @return
     */
    public Packing packing();

    /**
     * 价格
     *
     * @return
     */
    public float price();

}
