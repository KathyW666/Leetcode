public class Leetcode_172 {
    /**
     * AC 阶乘数最后有几个零，只和 2 和 5 有关系，25 = 5 * 5 所以有两个0，递归
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n = n / 5;
        }
        return res;
    }

    // return n == 0 ? 0 : n / 5 + trailingZeros(n / 5)
}
