package leetcode001_050;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yesongren on 2019/11/21
 * #017. Letter Combinations of a Phone Number
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('0', " ");
        map.put('1', "*");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        for (int digit = 0; digit < digits.length(); digit++) {
            if (result.size() == 0) {
                String letter = map.get(digits.charAt(digit));
                for (int i = 0; i < letter.length(); i++) {
                    result.add("" + letter.charAt(i));  //char --> String
                }
            } else {
                List<String> temps = new ArrayList<>();
                for (String res : result) {
                    String letter = map.get(digits.charAt(digit));
                    for (int i = 0; i < letter.length(); i++) {
                        temps.add(res + letter.charAt(i));
                    }
                }
                result.clear();  //去除第一次遍历加到result中的字母
                result.addAll(temps);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber obj = new LetterCombinationsOfAPhoneNumber();
        System.out.println(obj.letterCombinations("34"));
    }
}
