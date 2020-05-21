package cn.hello.jay.practice.algorithm.course04;

/**
 * @author 周健以
 * @Date 2020年05月19日
 */
public class Test {
    // 全局变量，大小为 10 的数组 array，长度 len，下标 i。
    int array[] = new int[10];
    int len = 10;
    int i = 0;

    // 往数组中添加一个元素
    void add(int element) {
        if (i >= len) { // 数组空间不够了
            // 重新申请一个 2 倍大小的数组空间
            int new_array[] = new int[len * 2];
            // 把原来 array 数组中的数据依次 copy 到 new_array
            for (int j = 0; j < len; ++j) {
                new_array[j] = array[j];
            }
            // new_array 复制给 array，array 现在大小就是 2 倍 len 了
            array = new_array;
            len = 2 * len;
        }
        // 将 element 放到下标为 i 的位置，下标 i 加一
        array[i] = element;
        ++i;
    }

    // min=O(1)
    // max=O(n)
    // avg=O(1)

    public static void main(String[] args) {
        int num = 0;
        for (int i = 0; i < 10; i++) {
            num += i;
        }
        System.out.println(num);
    }
}
