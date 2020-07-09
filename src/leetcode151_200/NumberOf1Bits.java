package leetcode151_200;

/**
 * Created by yesongren on 2020/7/9
 * 191. Number of 1 Bits
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int cnt = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & (mask << i)) != 0) cnt++;
        }
        return cnt;
    }
}
