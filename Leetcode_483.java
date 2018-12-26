import java.math.BigInteger;

public class Leetcode_483 {

    public String smallestGoodBase(String n) {
        long nn = Long.parseLong(n);
        long x = 0;
        // 2^60 已经超过 10^18 了，因此 k 被限制在 [2，60)
        // Binary Search
        int sub = 1;
        if (nn % 2 == 0) sub = 2;
        for (int k = 60; k >= 2; k -= sub) {
            long start = 2, end = nn;
            while (start < end) {
                long mid = start + (end - start) / 2;
                BigInteger num = BigInteger.valueOf(mid);
                num = num.pow(k).subtract(BigInteger.ONE);
                BigInteger den = BigInteger.valueOf(nn).
                        multiply(BigInteger.valueOf(mid).subtract(BigInteger.ONE));
                int cmp = num.compareTo(den);
                if (cmp == 0) {
                    x = mid;
                    break;
                } else if (cmp < 0) start = mid + 1;
                else end = mid;
            }
            if (x != 0) break;
        }
        return "" + x;
    }

}
