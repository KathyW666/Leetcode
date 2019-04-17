public class Leetcode_190 {
    /**
     * 比特反序，Java移位操作，补码，& | ^
     * 答案真简洁
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res << 1 | (n & 1);
            n >>>= 1;
        }
        return res;
    }
}
