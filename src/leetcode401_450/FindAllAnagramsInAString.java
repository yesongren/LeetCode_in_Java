package leetcode401_450;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yesongren on 2019/11/28
 * #438. Find All Anagrams in a String
 * <p>
 * Sliding Window
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {  // s: "cbaebabacd" p: "abc"
        int slen = s.length();
        int plen = p.length();
        List<Integer> result = new ArrayList<>();
        if (slen < plen) return result;

        int[] smap = new int[26];
        int[] pmap = new int[26];

        for (int j = 0; j < plen; j++) {
            pmap[p.charAt(j) - 'a']++;
        }
        for (int i = 0; i < slen; i++) {
            smap[s.charAt(i) - 'a']++;
            if (i >= plen) {
                smap[s.charAt(i - plen) - 'a']--;
            }
            if (Arrays.equals(smap, pmap)) {
                result.add(i - plen + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        FindAllAnagramsInAString obj = new FindAllAnagramsInAString();
        System.out.println(obj.findAnagrams(s, p));
    }
}
