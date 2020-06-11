package leetcode101_150;

/**
 * Created by yesongren on 2020/6/11
 * 125. Valid Palindrome
 */
public class ValidPalindrome {

    // filter Number and Alphabet
    public String filter(char ch) {
        StringBuilder sb = new StringBuilder();
        if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toLowerCase().toCharArray();
        for (char ch : chs) {
            sb.append(filter(ch));
        }
        String ss = sb.toString();
        return validate(ss, 0, ss.length() - 1);
    }

    public boolean validate(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
