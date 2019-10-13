package leetcode201_250;

/**
 * Created by yesongren on 2019/10/14
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] statS = new int[26];
        int[] statT = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            statS[index]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            statT[index]++;
        }

        for (int i = 0; i < 26; i++) {
            if (statS[i] != statT[i]) return false;
        }
        return true;
    }

    public boolean isAnagram2(String s, String t){
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ten";
        String s2 = "net";
        ValidAnagram obj = new ValidAnagram();
        System.out.println(obj.isAnagram2(s1,s2));
    }
}
