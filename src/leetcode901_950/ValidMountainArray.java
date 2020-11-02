package leetcode901_950;

/**
 * Created by yesongren on 2020/11/3
 * 941. Valid Mountain Array
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3)
            return false;

        int left = 0, right = A.length - 1;
        while (left < A.length - 2 && A[left] < A[left + 1])//注意循环完毕后,left指针只能到数组倒数第二个数位置
            left++;
        while (right > 1 && A[right] < A[right - 1])//和left指针条件一样
            right--;

        return left == right;

    }
}
