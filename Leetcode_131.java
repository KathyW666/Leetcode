import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Leetcode_131 {
    /**
     * AC 递归+判断回文 O(n*2^n)
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        if (s.length() == 0) return res;
        List<String> ans = new LinkedList<>();
        dfs(s, res, ans);
        return res;
    }

    private void dfs(String s, List<List<String>> res, List<String> ans) {
        if (s.length() <= 0) {
            res.add(new ArrayList<String>(ans));
            return;
        }
        int n = s.length();
        for (int i = 1; i <= n; i++) {
            String sub = s.substring(0, i);
            if (isPalindrome(sub)) {
                ans.add(sub);
                dfs(s.substring(i, n), res, ans);
                ans.remove(ans.size()-1);
            }
        }

    }

    private boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return true;
        int len = s.length();
        for (int i = 0; i < len / 2; i++)
            if (s.charAt(i) != s.charAt(len-1-i)) return false;
        return true;
    }

    /**
     * 优化：DP+递归+判断回文 O(2^n)
     */
}
