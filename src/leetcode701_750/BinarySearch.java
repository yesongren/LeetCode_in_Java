package leetcode701_750;

/**
 * Created by yesongren on 2020/7/31
 * 704. Binary Search
 */

/**
 * 两个可以直接套用的模板:
 *
 * 模板1：
 * public int searchInsert(int[] nums, int target) {
 *         int left = 0, right = nums.length - 1; // 注意
 *         while(left <= right) { // 注意
 *             int mid = (left + right) / 2; // 注意
 *             if(nums[mid] == target) { // 注意
 *                 // 相关逻辑
 *             } else if(nums[mid] < target) {
 *                 left = mid + 1; // 注意
 *             } else {
 *                 right = mid - 1; // 注意
 *             }
 *         }
 *         // 相关返回值
 *         return 0;
 *     }
 *
 * 模板2：
 * public int searchInsert(int[] nums, int target) {
 *         int left = 0, right = nums.length; // 注意
 *         while(left < right) { // 注意
 *             int mid = (left + right) / 2; // 注意
 *             if(nums[mid] == target) {
 *                 // 相关逻辑
 *             } else if(nums[mid] < target) {
 *                 left = mid + 1; // 注意
 *             } else {
 *                 right = mid; // 注意
 *             }
 *         }
 *         // 相关返回值
 *         return 0;
 *     }
 *
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l >> 1);
            if (nums[m] == target) return m;
            else if (nums[m] < target) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }
}
