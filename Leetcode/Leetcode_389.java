import java.util.HashMap;
import java.util.Map;

public class Leetcode_389 {
    /**
     * 比特操作 / hashmap
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char[] chars = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        for (int i = 0; i < chars.length - 1; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) return c;
            if (map.get(c) == 1) map.remove(c);
            else map.put(c, map.get(c)-1);
        }
        Character res = null;
        for (Character c : map.keySet()) {
            res = c;
        }
        return res;
    }

    public char findTheDifference2(String s, String t) {
        int n = s.length();
        char c = t.charAt(n);
        for (int i = 0; i < n; i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}
