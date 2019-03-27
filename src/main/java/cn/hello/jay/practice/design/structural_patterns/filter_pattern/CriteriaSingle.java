/**
 *
 */
package cn.hello.jay.practice.design.structural_patterns.filter_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 3.创建实现了Criteria接口的实体类--过滤单身
 *
 * @author 周健以
 * @Date 2019年03月06日
 */
public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singles = new ArrayList<>();
        for (Person person : persons) {
            if (SINGLE.equalsIgnoreCase(person.getMaritalStatus())) {
                singles.add(person);
            }
        }
        return singles;
    }
}
