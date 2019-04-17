import java.util.*;

/********************************
 * Similar with 139. WordBreak.
 *******************************/

public class Leetcode_472 {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, new cmp());
        for (int i = 0; i < words.length; i++) {
            if (wordBreak(words[i], preWords))
                res.add(words[i]);
            preWords.add(words[i]);
        }
        return res;
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        if (wordDict.isEmpty())
            return false;
        if (s == null || s.length() == 0)
            return false;
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i + 1; j++) {
                if (res[j] && wordDict.contains(s.substring(j, i + 1).toString())) {
                    res[i + 1] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
}

class cmp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}


