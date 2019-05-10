public class Leetcode_367 {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) return true;
        long l = 1, r = num;
        while(r >= l) {
            long mid = l + (r-l)/2;
            if (mid * mid < num) l = mid + 1;
            else if (mid * mid > num) r = mid - 1;
            else return true;
        }
        return false;
    }
}
