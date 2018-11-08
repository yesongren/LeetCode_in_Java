package leetcode001_050;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * #003 Longest Substring Without Repeating Characters
     *
     *  Description: Given a string, find the length of the longest substring without repeating characters.
     *
     *
     *  Example 1:
     *
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     *
     *
     *
     * Example 2:
     *
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     *
     *
     *
     * Example 3:
     *
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
            } else {
                set.add(s.charAt(i));
                res = Math.max(res, set.size());
            }
        }
        return res;
        //0 1 2 3 4 5 6 7       0 1 2 3 4
        //a b c a b c a a       a a b a a
    }
    public int lengthOfLongestSubstring2(String s) {
        int res = 0;
        if(s == null || s.length() == 0) return res;
        Set<Character> set = new HashSet<>();
        for(int i = 0, j = 0; i < s.length();) {
            if(set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
            }
            else {
                set.add(s.charAt(i++));
                res = Math.max(res, set.size());
                //res = set.size();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //String str = "aab";   //2
        //String str1 = "abcabcaa";  //3
        //String str2 = "pwwkwea";  //4
        String str3 = "aabaa";  //2
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        //System.out.println(obj.lengthOfLongestSubstring2(str));
        //System.out.println(obj.lengthOfLongestSubstring2(str1));
        //System.out.println(obj.lengthOfLongestSubstring2(str2));
        System.out.println(obj.lengthOfLongestSubstring2(str3));
    }
}
