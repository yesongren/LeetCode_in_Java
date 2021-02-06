package leetcode_1000plus;

/**
 * Created by yesongren on 2021/2/6
 * 1423. Maximum Points You Can Obtain from Cards
 * Two pointers
 */
public class LC1423_MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cards, int k) {
        int score = 0;
        for (int i = 0; i < k; i++) {
            score += cards[i];
        }
        int left = k - 1, right = cards.length, max = score;
        while (left >= 0) {
            score -= cards[left];
            left--;
            right--;
            score += cards[right];
            max = Math.max(max, score);
        }
        return max;
    }
}
