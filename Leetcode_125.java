public class Leetcode_125 {
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.length() == 0) return true;
            s = s.replaceAll("\\p{P}", "");
            s = s.replaceAll("[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]", "");
            s = s.replace(" ", "");
            s = s.toLowerCase();
            int n = s.length();
            int i = 0, j = n - 1;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) return false;
                i++;
                j--;
            }
            return true;
        }
    }
}
