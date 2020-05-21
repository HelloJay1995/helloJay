package cn.hello.jay.practice.algorithm.course07;

/**
 * @author 周健以
 * @Date 2020年05月20日
 */
public class Test {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("甲");
        System.out.println(list.toString());

        list.add("乙");
        System.out.println(list.toString());

        list.add("丙");
        System.out.println(list.toString());

        list.remove("乙");
        System.out.println(list.toString());

        list.remove("甲");
        System.out.println(list.toString());

        list.remove("丙");
        System.out.println(list.toString());

        list.remove("丁");
        System.out.println(list.toString());

    }
}
