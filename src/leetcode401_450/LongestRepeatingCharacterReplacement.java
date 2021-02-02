package leetcode401_450;

/**
 * Created by yesongren on 2021/2/2
 * 424. Longest Repeating Character Replacement
 * Sliding Window
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] cnter = new int[26];
        int start = 0, res = 0, maxCnt = 0;
        for (int end = 0; end < n; end++) {
            cnter[s.charAt(end) - 'A']++;
            int cnt = cnter[s.charAt(end) - 'A'];
            maxCnt = Math.max(cnt, maxCnt);

            while (end - start + 1 - maxCnt > k) {
                cnter[s.charAt(start) - 'A']--;
                start++;
            }
            res = Math.max(end - start + 1, res);
        }
        return res;
    }
}
