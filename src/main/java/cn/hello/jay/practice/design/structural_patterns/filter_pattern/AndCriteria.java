/**
 *
 */
package cn.hello.jay.practice.design.structural_patterns.filter_pattern;

import java.util.List;

/**
 * 3.创建实现了Criteria接口的实体类--双重过滤
 *
 * @author 周健以
 * @Date 2019年03月06日
 */
public class AndCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}
