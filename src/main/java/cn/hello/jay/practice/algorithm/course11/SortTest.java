package cn.hello.jay.practice.algorithm.course11;

import cn.hello.jay.practice.algorithm.course13.CountSort;

import java.util.Random;

/**
 * @author 周健以
 * @Date 2020年05月24日
 */
public class SortTest {

    public static void main(String[] args) {
        int[] arr = createData(100000);
        printArr(arr);
        CountSort.sort(arr);
//        QuickSort.quickSort(arr, 0, arr.length - 1);
        printArr(arr);
        checkArr(arr);
    }

    public static int[] createData(int size) {
        Random ran = new Random();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = ran.nextInt(1000);
        }
        return res;
    }

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.printf("%4d", i);
        }
        System.out.println();
    }

    public static void checkArr(int[] arr) {
        Integer prev = null;
        for (int i : arr) {
            if (prev == null) {
                prev = i;
            }
            if (prev > i) {
                System.out.println("检测未通过");
                break;
            }
            prev = i;
        }
        System.out.println("检测通过");
    }
}
