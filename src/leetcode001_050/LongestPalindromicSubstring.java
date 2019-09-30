package leetcode001_050;

/**
 * Created by yesongren on 2019/9/30
 */
public class LongestPalindromicSubstring {
    private int longestSize = 0;
    private int longestStart = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 0) return "";
        for (int index = 0; index < s.length(); index++) {
            checkOdd(s, index);
            checkEven(s, index);
        }
        return s.substring(longestStart, longestStart + longestSize + 1);
    }

    public void checkOdd(String s, int index) {
        int start = index;
        int end = index;
        while (start >= 1 && end < s.length() - 1 && s.charAt(start - 1) == s.charAt(end + 1)) {
            start -= 1;
            end += 1;
        }
        if (end - start > longestSize) {
            longestSize = end - start;
            longestStart = start;
        }
    }

    public void checkEven(String s, int index) {
        int start = index;
        int end = Math.min(index + 1, s.length() - 1);
        while (start >= 1 && end < s.length() - 1 && s.charAt(start - 1) == s.charAt(end + 1) && s.charAt(start) == s.charAt(end)) {
            start -= 1;
            end += 1;
        }
        if (end - start > longestSize && s.charAt(start) == s.charAt(end)) {
            longestSize = end - start;
            longestStart = start;
        }
    }
}
