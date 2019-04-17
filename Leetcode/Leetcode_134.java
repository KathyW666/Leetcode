public class Leetcode_134 {
    /**
     * AC 暴力求解 O(n^2) O(n)
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] res = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            res[i] = gas[i] - cost[i];
        }
        for (int i = 0; i < gas.length; i++) {
            if (res[i] >= 0) {
                int start = (i == gas.length-1) ? 0 : i+1;
                int sum = res[i];
                while (start != i) {
                    sum += res[start];
                    if (sum < 0) break;
                    start++;
                    if (start == gas.length) start = 0;
                }
                if (start == i) return i;
            }
        }
        return -1;
    }

    /**
     * 贪心优化 思路
     * firstPass 确定循环，secondPass 确定sum能否满足成圈
     *
     * @param gas
     * @param cost
     * @return
     */
    public int method2(int[] gas, int[] cost) {
        int[] res = new int[gas.length];
        int start =0, sum = 0;
        for (int i = 0; i < gas.length; i++) {
            res[i] = gas[i] - cost[i];
            sum += res[i];
            if (sum < 0) {
                sum = 0;
                start = i + 1;
                if (start == gas.length) return -1;
            }
        }
        int result = start;
        sum = 0;
        for (int i = 0; i < gas.length; i++) {
            if (start+i == gas.length) start = -i;
            sum += res[start+i];
            if (sum < 0) return -1;
        }
        return result;
    }
}
