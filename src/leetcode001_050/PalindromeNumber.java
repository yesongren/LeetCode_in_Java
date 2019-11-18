package leetcode001_050;

/**
 * Created by yesongren on 2019/11/17
 * #009.  Palindrome Number
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int tmp = x;
        if (x == 0) return true;
        if (x < 0) return false;
        int reverse = 0;
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return tmp == reverse;
    }

    public boolean isPalindrome2(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        if (x == reverse || x == reverse / 10) return true;
        else return false;
    }

    public static void main(String[] args) {
        int x = 1010;
        boolean a;
        PalindromeNumber obj = new PalindromeNumber();
        a = obj.isPalindrome2(x);
        System.out.println(a);
    }
}
