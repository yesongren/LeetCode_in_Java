package leetcode401_450;

/**
 * Created by yesongren on 2020/8/3
 * 415. Add Strings
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = a + b + carry;
            res.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        if (carry == 1) res.append("1");
        return res.reverse().toString();
    }
}
