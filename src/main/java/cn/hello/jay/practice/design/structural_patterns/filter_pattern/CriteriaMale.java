/**
 *
 */
package cn.hello.jay.practice.design.structural_patterns.filter_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 3.创建实现了Criteria接口的实体类--过滤男性
 *
 * @author 周健以
 * @Date 2019年03月05日
 */
public class CriteriaMale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> males = new ArrayList<>();
        for (Person person : persons) {
            if (MALE.equalsIgnoreCase(person.getGender())) {
                males.add(person);
            }
        }
        return males;
    }
}
