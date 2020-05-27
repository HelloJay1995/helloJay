package cn.hello.jay.practice.algorithm.course15;

/**
 * @author 周健以
 * @Date 2020年05月25日
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {8, 11, 19, 23, 27, 33, 45, 55, 67, 98};
        int index1 = search(arr, 67);
        int index2 = searchByRecursive(arr, 67, 0, arr.length - 1);
        System.out.println(index1 + "," + index2);
    }

    public static int search(int[] arr, int value) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int searchByRecursive(int[] arr, int value, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
        return searchByRecursive(arr, value, low, high);
    }
}
