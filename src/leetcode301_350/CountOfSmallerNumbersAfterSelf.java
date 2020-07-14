package leetcode301_350;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/7/11
 * 315. Count of Smaller Numbers After Self
 */
public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> cnt = new ArrayList<>();
        if (nums == null || nums.length == 0) return cnt;
        int[] mapping = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            mapping[i] = i;
            cnt.add(0);
        }
        int[] helper = new int[nums.length];
        mergeSort(nums, helper, 0, nums.length - 1, cnt, mapping);
        return cnt;
    }

    public void mergeSort(int[] arr, int[] helper, int l, int r, List<Integer> cnt, int[] mapping) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(arr, helper, l, mid, cnt, mapping);
        mergeSort(arr, helper, mid + 1, r, cnt, mapping);
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (arr[mapping[i]] <= arr[mapping[j]]) {
                helper[k++] = mapping[j++];
            } else {
                int update = r - j + 1;
                cnt.set(mapping[i], cnt.get(mapping[i]) + update);
                helper[k++] = mapping[i++];
            }
        }
        while (i <= mid) {
            helper[k++] = mapping[i++];
        }
        while (j <= r) {
            helper[k++] = mapping[j++];
        }
        for (i = l, k = 0; i <= r; i++, k++) {
            mapping[i] = helper[k];
        }
    }
}
