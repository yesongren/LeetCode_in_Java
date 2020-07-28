package leetcode351_400;

/**
 * Created by yesongren on 2020/7/28
 * 392. Is Subsequence
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }
}
