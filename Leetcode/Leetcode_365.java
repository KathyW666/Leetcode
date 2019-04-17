public class Leetcode_365 {

    public boolean canMeasureWater(int x, int y, int z) {
        if (x * y == 0)
            return (z == x || z == y);
        int div = commonDivisor(x, y);
        if (z % div == 0 && z <= x + y)
            return true;
        else
            return false;
    }

    public int commonDivisor(int x, int y) {
        if (x > y) {
            int temp = y;
            y = x;
            x = temp;
        }
        int yu = y % x;
        while (yu != 0) {
            y = x;
            x = yu;
            yu = y % x;
        }
        return x;
    }

}
