package leetcode601_650;

/**
 * Created by yesongren on 2020/4/17
 * 647. Palindromic Substrings
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
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

    public static void main(String[] args) {
        String s = "abbc";
        PalindromicSubstrings obj = new PalindromicSubstrings();
        System.out.println(obj.countSubstrings(s));
    }
}
