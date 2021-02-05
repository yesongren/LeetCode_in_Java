package leetcode_1000plus;

/**
 * Created by yesongren on 2021/2/5
 * 1234. Replace the Substring for Balanced String
 */
public class LC1234_ReplaceTheSubstringForBalancedString {
    public int balancedString(String s) {
        int standard = s.length() / 4;  // 每种字符的标准数量
        int[] cnter = new int[26];  // 记录每种字符出现的次数
        char[] chs = s.toCharArray();
        for (char ch : chs) {  // 统计每种字符出现的次数
            cnter[ch - 'A']++;
        }
        // isValid方法用来判断每种字符的数量是否小于等于标准数量
        if (isValid(cnter, standard)) return 0;
        int res = s.length(), left = 0;
        // 当前区间为[left, right]
        for (int right = 0; right < chs.length ; right++) {
            // 当前字符数量减一，减一的目的是为了统计当前区间外每种字符的个数
            cnter[chs[right] - 'A']--;
            if (isValid(cnter, standard)) {
                res = Math.min(res, right - left + 1);
                // 向右移动左指针，移动范围是[left, right]
                for (int j = left; j <= right; j++) {
                    cnter[chs[j] - 'A']++;
                    left++;
                    if (isValid(cnter, standard)) res = Math.min(res, right - left + 1);
                    else break;
                }
            }
        }
        return res;
    }

    private boolean isValid(int[] cnter, int len) {
        return cnter[4] <= len
                && cnter[16] <= len
                && cnter[17] <= len
                && cnter[22] <= len;
    }
}
