/**
 *
 */
package cn.hello.jay.practice.design.structural_patterns.filter_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 3.创建实现了Criteria接口的实体类--过滤女性
 *
 * @author 周健以
 * @Date 2019年03月06日
 */
public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> females = new ArrayList<>();
        for (Person person : persons) {
            if (FEMALE.equalsIgnoreCase(person.getGender())) {
                females.add(person);
            }
        }
        return females;
    }
}
