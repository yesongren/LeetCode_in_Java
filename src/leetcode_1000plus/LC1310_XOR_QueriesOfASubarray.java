package leetcode_1000plus;

/**
 * Created by yesongren on 2020/7/29
 * 1310. XOR Queries of a Subarray
 */
public class LC1310_XOR_QueriesOfASubarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] pre = new int[arr.length];
        pre[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            pre[i] = (pre[i - 1] ^ arr[i]);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            if (q[0] == 0) res[i] = pre[q[1]];
            else res[i] = pre[q[0] - 1] ^ pre[q[1]];
        }
        return res;
    }
}
