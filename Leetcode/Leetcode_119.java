import java.util.LinkedList;
import java.util.List;

// AC 杨辉三角
public class Leetcode_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new LinkedList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> ans = new LinkedList<>();
            ans.add(1);
            for (int j = 0; j < i - 1; j++)
                ans.add(res.get(j) + res.get(j+1));
            ans.add(1);
            res = ans;
        }
        return res;
    }
}
