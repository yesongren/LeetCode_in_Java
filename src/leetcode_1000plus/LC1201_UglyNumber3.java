package leetcode_1000plus;

/**
 * Created by yesongren on 2020/1/16
 * 1201. Ugly Number III
 * 容斥原理， 二分查找
 */
public class LC1201_UglyNumber3 {

    public long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ac = lcm(c, a);
        long abc = lcm(bc, a);
        long left = 1;
        long right = 2000000000;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long cnt = mid / a + mid / b + mid / c - mid / ab - mid / bc - mid / ac + mid / abc;
            if (cnt >= n) right = mid;
            else left = mid + 1;
        }
        return (int) left;
    }
}
