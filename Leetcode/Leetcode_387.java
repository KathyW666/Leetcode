import java.util.HashMap;
import java.util.Map;

public class Leetcode_387 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0)+1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode_387 o = new Leetcode_387();
        o.firstUniqChar("leetcode");
    }
}
