package leetcode551_600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yesongren on 2021/1/22
 * 556. Next Greater Element III
 */
public class NextGreaterElement3 {
    public int nextGreaterElement(int n) {
        int temp_n = n;
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        Collections.reverse(list);
        int[] d = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            d[i] = list.get(i);
        }
        for (int i = d.length - 1; i >= 1; i--) {
            if (d[i] > d[i - 1]) {
                int tempIdx = i;
                for(int j = i; j < d.length; j++) {
                    if (d[j] > d[i - 1] && d[j] < d[tempIdx]) tempIdx = j;
                }
                swap(d, i - 1, tempIdx);
                int[] arr = new int[d.length - i];
                System.arraycopy(d, i, arr, 0, d.length - i);
                Arrays.sort(arr);
                System.arraycopy(arr, 0, d, i, arr.length);
                break;
            }
        }
        int res = 0;
        for (int digit : d) {
            res = res * 10 + digit;
        }
        return res <= temp_n ? -1 : res;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
