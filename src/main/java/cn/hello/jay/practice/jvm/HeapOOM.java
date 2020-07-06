package cn.hello.jay.practice.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 周健以
 * @Date 2020年06月22日
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
