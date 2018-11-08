package leetcode101_150;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) return res;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            list.add(1);
            for (int j = list.size() - 2; j > 0; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }

    public static void main(String[] args) {
        PascalsTriangle1 pascalsTriangle1 = new PascalsTriangle1();
        System.out.println(pascalsTriangle1.generate(5));
    }
}
