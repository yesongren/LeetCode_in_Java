package leetcode101_150;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
    /** 119 杨辉三角2
     *
     */
    public List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            row.add(0,1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
        }
        return row;
    }

    public static void main(String[] args) {
        PascalsTriangle2 obj = new PascalsTriangle2();
        System.out.println(obj.getRow(3));
        System.out.println(obj.getRow(5));  // res: [1, 5, 10, 10, 5, 1]
        System.out.println(obj.getRow(-1));
    }
}
