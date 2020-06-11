package leetcode601_650;

/**
 * Created by yesongren on 2020/4/17
 * 647. Palindromic Substrings
 */
public class PalindromicSubstrings {

    // Time: O(n^2), Space: O(n^2)
    public int countSubstringsDP(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int cnt = 0;
        boolean[][] d = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) d[i][j] = true;
                else if (i + 1 == j) d[i][j] = s.charAt(i) == s.charAt(j);
                else d[i][j] = s.charAt(i) == s.charAt(j) && d[i + 1][j - 1];

                if (d[i][j]) cnt++;
            }
        }
        return cnt;
    }

    // Time: O(n^2), Space: O(1)
    public int countPalindromicSubstringsExpand(String s) {
        if (s == null || s.length() < 1) return 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt += expandAndCount(s, i, i);
            cnt += expandAndCount(s, i, i + 1);
        }
        return cnt;
    }
    public int expandAndCount(String s, int left, int right) {
        int cnt = 0;
        while (left >= 0 && right <= s.length() && s.charAt(left) == s.charAt(right)) {
            cnt++;
            left--;
            right++;
        }
        return cnt;
    }
}
