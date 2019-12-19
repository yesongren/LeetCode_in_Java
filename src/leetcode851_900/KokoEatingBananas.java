package leetcode851_900;

/**
 * Created by yesongren on 2019/11/27
 * #875. Koko Eating Bananas
 * Binary Search
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

    public int minEatingSpeed2(int[] piles, int H) {
        int low = 1;
        int high = Integer.MAX_VALUE;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canEat(piles, H, mid)) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    public boolean canEat(int[] piles, int H, int K) {
        int total = 0;
        for (int pile : piles) {
            // total += pile / K;
            // if (pile % K != 0) total++;
            total += (pile + K - 1) / K;
        }
        return total <= H;
    }
}
