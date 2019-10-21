package leetcode051_100;

/**
 * Created by yesongren on 2019/10/17
 * LeetCode #088. Merge Sorted Array
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                arr[k] = nums1[i];
                i++;
            }
            else {
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while (j < n) {
            arr[k] = nums2[j];
            j++;
            k++;
        }
        for (i = 0; i < k; i++) {
            nums1[i] = arr[i];
        }
    }
}
