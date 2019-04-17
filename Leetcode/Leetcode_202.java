import java.util.HashSet;
import java.util.Set;

public class Leetcode_202 {

    private Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        int num = 0;
        while (n > 0) {
            num += (n % 10) * (n % 10);
            n = n / 10;
        }
        if (!set.add(num)) {
            if (num == 1) return true;
            else return false;
        } else return isHappy(num);
    }
}
