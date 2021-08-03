package leetcode001_050;

/**
 * Created by yesongren on 2021/8/3
 * <p>
 * 34. Find First and Last Position of Element in Sorted Array
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return new int[]{-1, -1};
        int firstPos = findFirst(nums, target);
        if (firstPos == -1) return new int[]{-1, -1};
        int lastPos = findLast(nums, target);
        return new int[]{firstPos, lastPos};
    }

    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left >> 1);
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] != target) return -1;
        else return left;
    }

    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left >> 1);
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) return left;
        if (nums[left - 1] == target) return left - 1;
        else return -1;
    }
}
