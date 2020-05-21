package cn.hello.jay.practice.jdk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;

/**
 * @author 周健以
 * @Date 2020年05月05日
 */
@Data
public class ReferTest {

    private String arg;
    private OtherTest otherTest;

    public ReferTest(OtherTest otherTest) {
        arg = "ReferTest_args";
        this.otherTest = otherTest;
        System.out.println(otherTest.getArgs());
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 7200 * -1);
        Date startTime = calendar.getTime();
        System.out.println(JSON.toJSONString(startTime, SerializerFeature.WriteDateUseDateFormat));
    }

}
