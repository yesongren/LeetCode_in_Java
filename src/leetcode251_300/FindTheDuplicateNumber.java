package leetcode251_300;

/**
 * Created by yesongren on 2021/1/31
 * 287. Find the Duplicate Number
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] A) {
        int n = A.length - 1;
        // 创建新数组，使首元素为0，对应index = 0，方便index与value匹配
        int[] nums = new int[n + 2];
        nums[0] = 0;
        System.arraycopy(A, 0, nums, 1, n+1);
        for (int i = 1; i <= n + 1; i++) {
            // 1. idx != val; 2. idx：nums[i]越界，超出数组最长下标; 3. 如果待交换的两个val相等，那么交换无意义
            while (nums[i] != i && nums[nums[i]] <= n + 1 && nums[i] != nums[nums[i]]) {
                swap(nums, nums[i], i);
            }
        }
        for (int i = 0; i <= n + 1; i++) {
            if (nums[i] != i) return nums[i];
        }
        return -1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
