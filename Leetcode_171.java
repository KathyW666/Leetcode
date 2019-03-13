public class Leetcode_171 {
    /**
     * AC A - 1, B - 2... Z - 26, AA - 27....
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for(int i = chars.length - 1; i >= 0; i--) {
            res += (chars[i]-'A' + 1) * Math.pow(26, chars.length - i - 1);
        }
        return res;
    }
}
