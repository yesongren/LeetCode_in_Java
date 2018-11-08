package leetcode001_050;

public class SearchInsertPosition {
    /**
     * #035 Search Insert Position
     *
     * Description:
     *
     * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     *
     * You may assume no duplicates in the array.
     *
     * Example 1:
     * Input: [1,3,5,6], 5
     * Output: 2
     *
     * Example 2:
     * Input: [1,3,5,6], 2
     * Output: 1
     *
     * Example 3:
     * Input: [1,3,5,6], 7
     * Output: 4
     *
     * Example 4:
     * Input: [1,3,5,6], 0
     * Output: 0
     */

    public int searchInsert(int[] nums, int target) {
        /**
         * Weixin's method 1
         */
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = (start + end) >> 1;
            int midNum = nums[mid];
            if (midNum < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public int searchInsert1(int[] nums, int target) {
        /**
         * Weixin's method 2
         */
        int start = 0;
        int end = nums.length - 1;
        int ans = nums.length;
        while (start <= end) {
            int mid = (start + end) >> 1;
            int midNum = nums[mid];

            if (midNum >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public int searchInsert2(int[] nums, int target) {
        /**
         * my method
         */
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (target < nums[mid]) end = mid;
            else if (target > nums[mid]) start = mid;
            else return mid;
        }
        if (target <= nums[start]) {
            return start;
        } else if (target <= nums[end]) {
            return end;
        } else {
            return end + 1;
        }
    }

    public int searchInsert3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {     // 不加等号答案就是3
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 6, 8, 9};
        SearchInsertPosition obj = new SearchInsertPosition();
        System.out.println(obj.searchInsert3(array, 7));
    }
}
