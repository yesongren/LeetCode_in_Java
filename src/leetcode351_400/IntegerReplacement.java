package leetcode351_400;

/**
 * Created by yesongren on 2020/7/15
 * 397. Integer Replacement
 */
public class IntegerReplacement {
    public int integerReplacement(int n) {
        return integerReplacement((long) n);
    }

    public int integerReplacement(long n) {
        int res = 0;
        if (n <= 1) return 0;
        else if (n % 2 == 0) res = integerReplacement(n / 2) + 1;
        else res = Math.min(integerReplacement(n + 1), integerReplacement(n - 1)) + 1;
        return res;
    }
}
