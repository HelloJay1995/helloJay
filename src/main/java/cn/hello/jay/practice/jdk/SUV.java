/**
 *
 */
package cn.hello.jay.practice.jdk;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DecimalFormat;

/**
 * @author 周健以
 * @Date 2019年01月14日
 */
public class SUV extends Car {
    private String name = "suv";

    public SUV(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        boolean isReadBefore = new DateTime(new DateTime()).compareTo(DateTime.parse("2020-05-01 00:00:00", formatter)) < 0;
        System.out.println(isReadBefore);
    }

    //格式化数字表示
    public static String formatString(float data) {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return df.format(data);
    }

    public static String formatString2(float data) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(data);
    }
}
