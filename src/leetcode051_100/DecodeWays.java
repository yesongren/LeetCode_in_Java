package leetcode051_100;

/**
 * Created by yesongren on 2020/6/7
 * 91. Decode Ways
 */
public class DecodeWays {
    public int numDecodings(String ss) {
        char[] s = ss.toCharArray();
        int n = s.length;
        if (n == 0) return 0;

        int[] f = new int[n + 1];
        f[0] = 1;

        // first i digits
        for (int i = 1; i <= n; ++i) {
            f[i] = 0;
            // last digit
            int t = s[i - 1] - '0';
            if (t >= 1 && t <= 9) f[i] += f[i - 1];
            if (i >= 2) {
                // last two digits
                t = (s[i - 2] - '0') * 10 + (s[i - 1] - '0');
                if (t >= 10 && t <= 26) f[i] += f[i - 2];
            }
        }

        return f[n];
    }
}
