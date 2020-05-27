package cn.hello.jay.practice.algorithm.course08;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author 周健以
 * @Date 2020年05月22日
 */
@Data
public class ArrayStack {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        for (int i = 0; i < 4; i++) {
            stack.push(String.valueOf(i));
            System.out.println(JSON.toJSONString(stack));
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(stack.pop());
            System.out.println(JSON.toJSONString(stack));
        }
    }

    private String[] items;
    private int count;
    private int maxNum;

    public ArrayStack(int maxNum) {
        this.items = new String[maxNum];
        this.count = 0;
        this.maxNum = maxNum;
    }

    public boolean push(String item) {
        if (count == maxNum) {
            return false;
        }
        items[count++] = item;
        return true;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }
        String item = items[--count];
        items[count] = null;
        return item;
    }
}
