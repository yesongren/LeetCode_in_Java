package leetcode201_250;

/**
 * Created by yesongren on 2019/10/21
 * LeetCode #231. Power of Two
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        while (n % 2 == 0) {n /= 2;}
        if (n == 1) return true;
        else return false;
    }

    //位运算,用逻辑与&
    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) return false;
        else return (n & (n - 1)) == 0;
    }
}
