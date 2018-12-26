public class Leetcode_517 {

    public int findMinMoves(int[] machines) {
        if (machines.length == 0) return -1;
        if (machines.length == 1) return 0;
        int sum = 0, max = 0, ave = 0, count = 0;
        for (int i = 0; i < machines.length; i++) {
            sum += machines[i];
            if (machines[i] > max)
                max = machines[i];
        }
        if (sum % machines.length != 0) return -1;
        ave = sum / machines.length;
        max = max - ave;
        for (int i : machines) {
            count += i - ave;
            if (Math.abs(count) > max)
                max = Math.abs(count);
        }
        return max;
    }

}
