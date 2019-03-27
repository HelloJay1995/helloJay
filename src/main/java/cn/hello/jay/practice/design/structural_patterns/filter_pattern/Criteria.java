/**
 *
 */
package cn.hello.jay.practice.design.structural_patterns.filter_pattern;

import java.util.List;

/**
 * 为Criteria(标准)创建一个接口
 *
 * @author 周健以
 * @Date 2019年03月05日
 */
public interface Criteria {

    /**
     * 男性
     */
    public static final String MALE = "MALE";
    /**
     * 女性
     */
    public static final String FEMALE = "FEMALE";
    /**
     * 单身
     */
    public static final String SINGLE = "SINGLE";

    /**
     * 获取指定的人群
     *
     * @param persons
     * @return
     */
    List<Person> meetCriteria(List<Person> persons);
}
