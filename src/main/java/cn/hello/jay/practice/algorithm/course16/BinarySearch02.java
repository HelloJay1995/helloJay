package cn.hello.jay.practice.algorithm.course16;

/**
 * @author 周健以
 * @Date 2020年05月25日
 */
public class BinarySearch02 {

    public static void main(String[] args) {
        int[] arr = {8, 11, 19, 19, 19, 23, 27, 33, 45, 55, 67, 67, 98};
        int index = search(arr, 19);
        System.out.println(index);
    }

    /**
     * 查找最后一个值等于给定值的元素
     */
    public static int search(int[] arr, int value) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == value) {
                if (mid == high || arr[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
