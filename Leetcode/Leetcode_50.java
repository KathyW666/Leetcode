public class Leetcode_50 {
    // AC 红红火火恍恍惚惚
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    public double myPow1(double x, int n) {
        if (n == 0) return 1.0;
        double temp = myPow1(x, n / 2);
        if (n % 2 == 0) return temp * temp;
        else {
            if (n > 0) return temp * temp * x;
            else return temp * temp / x;
        }
    }
}
