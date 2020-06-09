package leetcode001_050;

/**
 * Created by yesongren on 2020/5/2
 * 50. Pow(x, n)
 */
public class Pow_x_n {
    /**
     * 数可以表示为2进制，2进制表示中的每一位的1都可以诠释为数次方
     *
     * 假设求a^b,按照朴素算法就是把a连乘b次，这样一来时间复杂度是O(n)级，快速幂能做到O(logn)
     * 首先把b写成它的二进制形式，设该二进制数第i位的权值为2^(i-1)，i * 2^(i-1)是每一次要做的乘方次数
     * 那么假设b=11，11的二进制是1011，11 = 2³×1 + 2²×0 + 2¹×1 + 2º×1=2³+2¹+2º，所以：a¹¹= a^2º* a ^2¹ * a^2³
     *
     * 代码中n&1是取末位，只有当前位为1时才要乘； n/=2是将n右移一位，取新的位做末位；x*=x就是X^(2^i)，是下一次要乘的因子
     */
    public double myPow(double x, int n) {
        int temp_n = n;
        double ans = 1;
        while (n != 0) {
            if ((n & 1) != 0) {//和1与取末尾
                ans *= x;
            }
            x *= x;
            n /= 2;//相当于数字右移，每次取新的位做末位
        }
        return temp_n >= 0 ? ans : 1 / ans;

    }
}
