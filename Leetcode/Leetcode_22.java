import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leetcode_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String par = "";
        int i = 0, j = 0;
        backtrack(res, par, i, j, n);
        return res;
    }

    public void backtrack(List<String> res, String par, int i, int j, int n) {
        if (par.length() == 2 * n) {
            res.add(par);
            return;
        }
        if (i < n) backtrack(res, par + "(", i+1, j, n);
        if (j < i) backtrack(res, par + ")", i, j+1, n);
    }

    public static void main(String[] args) {
        Leetcode_22 o = new Leetcode_22();
        while (true) {
            Scanner input = new Scanner(System.in);
            int num = input.nextInt();
            System.out.println(o.generateParenthesis(num));
        }
    }
}
