package leetcode451_500;

/**
 * Created by yesongren on 2020/8/24
 *  459. Repeated Substring Pattern
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        return ss.substring(1, ss.length() - 1).contains(s);
    }
}
