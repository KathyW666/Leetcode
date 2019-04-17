import java.util.HashMap;

public class Leetcode_205 {
        public boolean isIsomorphic(String s, String t) {
            HashMap<Character, Character> map1 = new HashMap<>();
            HashMap<Character, Character> map2 = new HashMap<>();
            if (s.length() == 0 && t.length() == 0) return true;
            if (s.length() != t.length()) return false;
            int len = s.length();
            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();
            for (int i = 0; i < len; i++) {
                if (!map1.containsKey(ss[i])) map1.put(ss[i], tt[i]);
                else if (map1.get(ss[i]) != tt[i]) return false;
                if (!map2.containsKey(tt[i])) map2.put(tt[i], ss[i]);
                else if (map2.get(tt[i]) != ss[i]) return false;
            }
            return true;
        }
}
