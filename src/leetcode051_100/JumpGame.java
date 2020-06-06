package leetcode051_100;

/**
 * Created by yesongren on 2020/6/5
 * 55. Jump Game
 */
public class JumpGame {

    // dp
    public boolean canJumpDP(int[] nums) {
        if (nums == null || nums.length < 1) return false;
        int n = nums.length;
        boolean[] f = new boolean[n];
        f[0] = true;
        for (int i = 1; i < n; ++i) {
            f[i] = false;
            for (int prev = 0; prev < i; ++prev) {
                if (f[prev] && nums[prev] + prev >= i) f[i] = true;
            }
        }
        return f[n - 1];
    }

    // Greedy
    public boolean canJumpGreedy(int[] nums) {
        if (nums == null || nums.length < 1) return false;
        int maxCanJump = 0;  // 最远可达下标
        int n = nums.length;
        for (int i = 0; i < n; ++i) {  // i ==> 当前下标
            if (maxCanJump >= n - 1) return true;
            if (maxCanJump < i) return false;
            maxCanJump = Math.max(maxCanJump, i + nums[i]);
        }
        return false;
    }
}
