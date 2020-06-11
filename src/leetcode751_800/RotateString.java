package leetcode751_800;

/**
 * Created by yesongren on 2020/6/11
 * 796. Rotate String
 */
public class RotateString {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
