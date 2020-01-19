package leetcode301_350;

/**
 * Created by yesongren on 2020/1/18
 * 344. Reverse String
 * two pointers
 */
public class ReverseString {
    public void reverseString(char[] s) {
        char tmp;
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }

    public void reverseString2(char[] s) {
        int start = -1;
        int end = s.length;
        while (++start < --end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] chs = {'h','e','l','l','o'};
        ReverseString obj = new ReverseString();
        obj.reverseString2(chs);
        System.out.println(chs);
    }
}
