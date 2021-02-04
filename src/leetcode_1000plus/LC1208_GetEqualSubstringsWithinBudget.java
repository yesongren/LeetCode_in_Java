package leetcode_1000plus;

/**
 * Created by yesongren on 2021/2/5
 * 1208. Get Equal Substrings Within Budget
 */
public class LC1208_GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int cost = 0, res = 0;
        for (int fast = 0, slow = 0; fast < s.length(); fast++) {
            cost += Math.abs(s.charAt(fast) - t.charAt(fast));
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(slow) - t.charAt(slow));
                slow++;
            }
            res = Math.max(res, fast - slow + 1);
        }
        return res;
    }
}
