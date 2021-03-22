package leetcode301_350;

/**
 * Created by yesongren on 2021/3/22
 * 338. Counting Bits
 */
public class CountingBits {
    // Time: O(num * k)
    // k is the number of "1" in the binary representation of num
    // Space: O(1);
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            res[i] = numberOfOne(i);
        }
        return res;
    }
    public int numberOfOne(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }

    // Time: O(n), Space: O(1);
    public int[] countBitsDP(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = f[i & (i - 1)] + 1;
        }
        return f;
    }
}
