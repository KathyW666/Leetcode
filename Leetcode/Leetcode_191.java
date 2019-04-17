public class Leetcode_191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if (n == 0) return 0;
        if (n % 2 != 0) return 1 + hammingWeight(n >>> 1);
        else return hammingWeight(n >>> 1);
    }

}
