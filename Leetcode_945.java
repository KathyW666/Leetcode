import java.util.Arrays;

public class Leetcode_945 {
    /**
     * 两种方法
     *
     * @param A
     * @return
     */
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0 || A.length == 1) return 0;
        Arrays.sort(A);
        int move = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                move += A[i - 1] + 1 - A[i];
                A[i] = A[i - 1] + 1;
            }
        }
        return move;

        // int[] count = new int[100000];
        // for (int x : A) count[x]++;
        // int ans = 0, taken = 0;
        // for (int x = 0; x < 100000; ++x) {
        //     if (count[x] >= 2) {
        //         taken += count[x]-1;
        //         ans -= x*(count[x]-1);
        //     }
        //     else if (taken > 0 && count[x] == 0) {
        //         taken--;
        //         ans += x;
        //     }
        // }
        // return ans;
    }
}
