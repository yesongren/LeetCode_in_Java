package leetcode_1000plus;

/**
 * Created by yesongren on 2021/2/23
 * 1052. Grumpy Bookstore Owner
 * sliding window
 */
public class LC1052_GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length, sum = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) sum += customers[i];
        }
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 1) sum += customers[i];
            if (i - X >= 0 && grumpy[i - X] == 1) sum -= customers[i - X];
            res = Math.max(sum, res);
        }
        return res;
    }
}
