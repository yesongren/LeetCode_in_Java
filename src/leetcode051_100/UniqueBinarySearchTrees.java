package leetcode051_100;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by yesongren on 2019/10/21
 * LeetCode #96. Unique Binary Search Trees
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        return getAns(1, n);
    }

    //普通递归方法
    public int getAns(int start, int end) {
        int ans = 0;
        if (start >= end) return 1;
        for (int i = start; i <= end; i++) {
            int leftTrees = getAns(start, i - 1);
            int rightTrees = getAns(i + 1, end);
            ans = ans + leftTrees * rightTrees;
        }
        return ans;
    }

    //简化普通递归
    public int simplifyGetAns(int n) {
        int ans = 0;
        if (n == 0 || n == 1) return 1;
        for (int i = 1; i <= n; i++) {
            int leftTrees = simplifyGetAns(i - 1);
            int rightTrees = simplifyGetAns(n - i);
            ans += leftTrees * rightTrees;
        }
        return ans;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees obj = new UniqueBinarySearchTrees();
        int a = obj.simplifyGetAns(3);
        System.out.println(a);
    }
}

/**
 * 用memorization减少递归时间
 */
class Memorization {
    public int numTrees(int n) {
        if (n == 0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        return getAns(n, map);
    }
    public int getAns(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n)) return map.get(n);
        int ans = 0;
        if (n == 0 || n == 1) return 1;
        for (int i = 1; i <= n; i++) {
            int leftNum = getAns(i - 1, map);
            int rightNum = getAns(n - i, map);
            ans += leftNum * rightNum;
        }
        return ans;
    }
}