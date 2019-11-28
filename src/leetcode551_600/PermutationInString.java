package leetcode551_600;

import java.util.Arrays;

/**
 * Created by yesongren on 2019/11/28
 * #567. Permutation in String
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 > l2) return false;

        int[] map1 = new int[26];
        for (int i = 0; i < l1; i++) {
            map1[s1.charAt(i) - 'a']++;
        }

        int[] map2 = new int[26];
        for (int j = 0; j < l2; j++) {
            map2[s2.charAt(j) - 'a']++;
            if (j >= l1) {
                map2[s2.charAt(j - l1) - 'a']--;
            }
            if (Arrays.equals(map2, map1)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        PermutationInString obj = new PermutationInString();
        System.out.println(obj.checkInclusion(s1, s2));  // true
    }
}
