package leetcode001_050;

public class ReverseInteger {
    /**
     * #007 Reverse Integer
     *
     * Description: Given a 32-bit signed integer, reverse digits of an integer.
     *
     * Example 1: Input: 123
     *            Output: 321
     *
     * Example 2: Input: -123
     *            Output: -321
     *
     * Example 3: Input: 120
     *            Output: 21
     *
     */
    public int reverse(int x) {
        long res = 0;  // int: -2 ^ 32 ~ 2 ^32 - 1 (-2147483648 ~ 2147483647)
        while (x != 0) {
            res = res * 10 + x % 10;  //通过取余来获取个位数字
            x /= 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        int x = 123;
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(x));
    }
}
