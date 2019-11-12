package leetcode251_300;

/**
 * Created by yesongren on 2019/11/11
 * #263. Ugly Number
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        int[] divisors = {2, 3, 5};
        for (int d : divisors) {
            while (num % d == 0) {
                num /= d;
            }
        }
        return num == 1;
    }

    public static void main(String[] args) {
        UglyNumber u = new UglyNumber();
        System.out.println(u.isUgly(20));
    }
}
