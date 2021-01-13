package leetcode201_250;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yesongren on 2021/1/13
 * 205. Isomorphic Strings
 */
public class IsomorphicStrings {
    // 双射函数
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(chs[i])) {
                if (map.get(chs[i]) == cht[i]) continue;
                else return false;
            } else {
                if (map.containsValue(cht[i])) return false;
                else map.put(chs[i], cht[i]);
            }
        }
        return true;
    }
}
