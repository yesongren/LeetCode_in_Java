package leetcode851_900;

/**
 * Created by yesongren on 2019/11/27
 * #875. Koko Eating Bananas
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = (int) Math.pow(10, 9);
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int totalTime = 0;
            for (int pile : piles) {
                totalTime += (pile + mid - 1) / mid;
            }
            if (totalTime > H) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}
