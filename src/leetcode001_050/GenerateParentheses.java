package leetcode001_050;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/7/15
 * 22. Generate Parentheses
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n < 1) return new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            res.add(new ArrayList<>());
        }
        res.get(0).add("");
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                for (String left : res.get(j)) {
                    for (String right : res.get(i - j - 1)) {
                        res.get(i).add('(' + left + ')' + right);
                    }
                }
            }
        }
        return res.get(n);
    }
}
