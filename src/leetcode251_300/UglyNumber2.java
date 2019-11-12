package leetcode251_300;

/**
 * Created by yesongren on 2019/11/12
 * #264. Ugly Number II
 */
public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index_2 = 0; int index_3 = 0; int index_5 = 0;
        int weight_2 = 2; int weight_3 = 3; int weight_5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(weight_2, weight_3), weight_5);
            ugly[i] = min;
            if (weight_2 == min) weight_2 = 2 * ugly[++index_2];
            if (weight_3 == min) weight_3 = 3 * ugly[++index_3];
            if (weight_5 == min) weight_5 = 5 * ugly[++index_5];
        }
        return ugly[n - 1];
    }

    public static void main(String[] args) {
        UglyNumber2 u = new UglyNumber2();
        System.out.println(u.nthUglyNumber(3));
    }
}
