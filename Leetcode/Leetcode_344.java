public class Leetcode_344 {
    /**
     * AC 反转数组
     * @param s
     */
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        for (int i = 0; i < s.length / 2; i++) {
            char cTemp = s[s.length - i - 1];
            s[s.length - i - 1] = s[i];
            s[i] = cTemp;
        }
    }
}
