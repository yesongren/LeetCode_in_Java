package leetcode001_050;

/**
 * Created by yesongren on 2021/2/3
 * 011. Container With Most Water
 * two pointers
 */
public class ContainerWithMostWater {
    public int maxArea(int[] H) {
        int left = 0, right = H.length - 1, area = 0;
        while (left < right) {
            int width = right - left;
            int height = Math.min(H[left], H[right]);
            area = Math.max(area, width * height);
            if (H[left] < H[right]) left++;
            else right--;
        }
        return area;
    }
}
