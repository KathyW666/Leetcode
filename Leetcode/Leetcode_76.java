import java.util.HashMap;
import java.util.Map;

/**
 * HashMap 存char出现的次数，（如果不用map直接判断，在s=bbaaa,t=aba时会出现问题）
 */
public class Leetcode_76 {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        Map<Character, Integer> dicT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dicT.getOrDefault(t.charAt(i), 0);
            dicT.put(t.charAt(i), count+1);
        }
        int required = dicT.size(); // 不重复的char的个数
        int l = 0, r = 0, len = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = new int[]{-1, 0, 0};
        while (r < s.length()) {
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count+1);
            if (dicT.containsKey(c) &&
                    windowCounts.get(c).intValue() == dicT.get(c).intValue())
                len++;
            while (l <= r && len == required) {
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dicT.containsKey(c)
                        && windowCounts.get(c).intValue() < dicT.get(c).intValue())
                    len--;
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
