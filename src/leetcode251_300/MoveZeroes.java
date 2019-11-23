package leetcode251_300;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by yesongren on 2019/11/23
 * #283. Move Zeroes
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {

        //method 1
        int n = nums.length;
        int zeros = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[i - zeros] = nums[i];
            } else {
                zeros++;
            }
        }
        int i = n - zeros;
        while (i < n) {
            nums[i++] = 0;
        }
    }

    public void moveZeros2(int[] nums) {

        //quick sort思想，分三段（1.不是0的， 2.全是0的， 3.还没走过的）
        // i: 还没有访问过的元素
        // j: 指向 0
        int n = nums.length;
        for (int i = 0, j = 0; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    //根据第二种算法的思路，改写快速排序：
    public int partition(int[] nums, int L, int R) {
        int pivot = nums[R];
        int i;
        int j = L;
        for (i = L; i < R; i++) {
            if (nums[i] < pivot) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
        int temp = nums[j];
        nums[j] = nums[R];
        nums[R] = temp;
        return j;
    }

    public void quickSort(int[] nums, int L, int R) {
        if (L < R) {
            int M = partition(nums, L, R);
            quickSort(nums, L, M - 1);
            quickSort(nums, M + 1, R);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 8, 1, 2, 5, 4};
        MoveZeroes obj = new MoveZeroes();
        obj.quickSort(nums, 0 ,5);
        System.out.println(Arrays.toString(nums));  // [1, 2, 3, 4, 5, 8]
    }
}
