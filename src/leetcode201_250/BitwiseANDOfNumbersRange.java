package leetcode201_250;

/**
 * Created by yesongren on 2020/8/24
 * 201. Bitwise AND of Numbers Range
 */
public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int cnt = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            cnt++;
        }
        return m << cnt;
    }
}
