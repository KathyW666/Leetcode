public class Leetcode_58 {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0 || s == null) return 0;
        int len = s.length();
        int count = 0;
        for(int i = len-1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (i == len - 1) len--;
                else break;
            }
            else count++;
        }
        return count;
    }
}
