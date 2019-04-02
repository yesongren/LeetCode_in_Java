package leetcode201_250;

import java.util.Arrays;


/**
 * Created by yesongren on 2019/4/1
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] fwd = new int[n], bwd = new int[n];
        fwd[0] = 1;
        bwd[n - 1] = 1;
        for (int i = 1; i < n; ++i) {
            fwd[i] = fwd[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; --i) {
            bwd[i] = bwd[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; ++i) {
            res[i] = fwd[i] * bwd[i];
        }
        return res;
    }

    public int[] productExceptSelf_opt(int[] nums) {
        int n = nums.length;
        int flag = 1;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; ++i) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        for (int i = n - 1; i >= 0; --i) {
            res[i] *= flag;
            flag *= nums[i];
        }
        return res;
    }

    public int[] productExceptSelf_best(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0, j = 1; i < n; i++) {
            res[i] = j;
            j *= nums[i];
        }
        for (int i = n - 1, j = 1; i >= 0; i--) {
            res[i] = res[i] * j;
            j = j * nums[i];
        }
        return res;
    }
}
