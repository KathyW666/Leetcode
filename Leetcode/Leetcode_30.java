import java.util.*;

public class Leetcode_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (s.length() == 0 || s == null || words.length == 0 || words == null)
            return res;
        int len = words[0].length();

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String w : words) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);

        for (int i = 0; i <= s.length() - words.length * len; ++i) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < words.length; ++j) {
                String str = s.substring(i + j * len, i + (j + 1) * len);
                if (copy.containsKey(str)) {
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count-1);
                    if (copy.isEmpty()) {
                        res.add(i);
                        break;
                    }
                }
                else break;
            }

        }
        return res;
    }
}
