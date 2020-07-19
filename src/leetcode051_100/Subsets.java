package leetcode051_100;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2019/10/22
 * LeetCode #078. Subsets
 */
public class Subsets {
    /**
     * 辅助递归函数
     *
     * @param nums  整数数组
     * @param start 数组开始下标
     * @param cur   当前数字组合
     * @param res   结果集合
     */
    private void subset(int[] nums, int start, List<Integer> cur, List<List<Integer>> res) {
        // 进入函数后，先把当前元素加入结果集合
        res.add(new ArrayList<>(cur));
        // 从下标start开始遍历数组
        for (int i = start; i < nums.length; i++) {
            // 取出一个数字，加入当前组合；然后递归调用自己
            cur.add(nums[i]);
            subset(nums, i + 1, cur, res);  // 由于子集中不能有重复数字，所以下一轮的开始下标start从 i + 1 开始
            cur.remove(cur.size() - 1);  // 退递归后，需要把当前组合最后加入的那个元素移除
        }
    }

    // Time: O(2 ^ n) 因为需要遍历所有子集
    // Space: O(n) 使用了一个大小为n的辅助list，并且递归深度也为n
    public List<List<Integer>> subsetsRec(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        subset(nums, 0, cur, res);
        return res;
    }

    //************************************* Solution 2 ***************************************


    // Time: O(n * 2 ^ n) 使用了2层循环，外层是2^n，内层循环次数是n
    // Space: O(1) 没有使用额外的空间
    public List<List<Integer>> subsetsBit(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int N = (int) Math.pow(2, n);  // 总共产生的子集数量为2的n次方
        for (int i = 0; i < N; i++) {  // 从0遍历到 N - 1, i的二进制位表示中，每一位的0和1就代表这一轮循环里，数组中相应的数字是否出现在当前子集中
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) cur.add(nums[j]);  // 检查当前二进制位是1还是0，如果是1，就把数组中相应位置的数字加入到当前集合中
            }
            res.add(cur);
        }
        return res;
    }
}
