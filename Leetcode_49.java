import java.util.*;

public class Leetcode_49 {
    // 答案好
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String strkey = String.valueOf(chars);
            if (!map.containsKey(strkey)) map.put(strkey, new ArrayList());
            map.get(strkey).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
