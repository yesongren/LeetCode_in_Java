package leetcode351_400;

/**
 * Created by yesongren on 2020/6/11
 * 371. Sum of Two Integers
 */
public class SumOfTwoIntegers {
    public int getSumRec(int a, int b) {
        return b == 0 ? a : getSumRec(a ^ b, (a & b) << 1);
    }

    public int getSumIter(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
