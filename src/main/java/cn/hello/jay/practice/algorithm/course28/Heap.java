package cn.hello.jay.practice.algorithm.course28;

import com.alibaba.fastjson.JSON;

/**
 * @author 周健以
 * @Date 2020年05月28日
 */
public class Heap {

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.sort();
        System.out.println(JSON.toJSONString(heap.a));
    }

    // 数组，从下表1开始存储数据
    private int[] a;
    // 数组最大可存储个数
    private int n;
    // 当前存储个数
    private int count;

    public Heap(int n) {
        this.n = n;
        a = new int[n + 1];
        count = 0;
    }

    /**
     * 插入到末尾，从下到上堆化
     */
    private void add(int data) {
        if (count >= n) {
            System.out.println("暂无空位");
            return;
        }
        ++count;
        a[count] = data;

        int i = count;
        while (i > 1 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    /**
     * 取末尾数据替换到根节点，从上到下堆化
     */
    private void delete() {
        a[1] = a[count];
        a[count--] = 0;
        heaping(a, 1, n);
    }

    private void sort() {
        // 建堆
        for (int i = n / 2; i > 0; i--) {
            heaping(a, i, n);
        }
        // 排序
        for (int k = n; k > 0; k--) {
            swap(a, 1, k);
            heaping(a, 1, k - 1);
        }
    }

    /**
     * 堆化
     */
    private void heaping(int[] a, int i, int n) {
        int maxIndex = i;
        while (maxIndex <= n) {
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxIndex = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxIndex] < a[i * 2 + 1]) {
                maxIndex = i * 2 + 1;
            }
            if (i == maxIndex) {
                return;
            }
            swap(a, i, maxIndex);
            i = maxIndex;
        }
    }


    private void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
