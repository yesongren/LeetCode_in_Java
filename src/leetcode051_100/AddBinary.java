package leetcode051_100;

/**
 * Created by yesongren on 2020/6/23
 * 67. 二进制求和
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0, sum = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            sum = carry;
            sum += (i >= 0 ? a.charAt(i) - '0' : 0);
            sum += (j >= 0 ? b.charAt(j) - '0' : 0);
            res.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}
