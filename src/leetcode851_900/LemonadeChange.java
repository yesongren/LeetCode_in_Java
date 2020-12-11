package leetcode851_900;

/**
 * Created by yesongren on 2020/12/11
 * 860. Lemonade Change
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five < 1) {
                    return false;
                } else {
                    five--;
                    ten++;
                }
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five > 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
