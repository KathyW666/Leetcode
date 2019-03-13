public class Leetcode_242 {

    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s.length() == 0 && t == "") return true;
        if (s.length() != t.length()) return false;
        int[] map = new int[256];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            map[s.charAt(i) - '0']++;
            map[t.charAt(i) - '0']--;
        }
        for (int i = 0; i < 256; i++) {
            if (map[i] != 0) return false;
        }
        return true;
    }

}
