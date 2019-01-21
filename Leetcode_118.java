import java.util.LinkedList;
import java.util.List;

//AC 杨辉三角
public class Leetcode_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows == 0) return res;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> ans = new LinkedList<>();
            if (i == 1) {
                ans.add(1);
                res.add(ans);
            }
            else {
                ans.add(1);
                for (int j = 0; j < i-2;j++)
                    ans.add(res.get(i-2).get(j)+res.get(i-2).get(j+1));
                ans.add(1);
                res.add(ans);
            }
        }
        return res;
    }
}
