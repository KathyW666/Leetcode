import java.util.ArrayList;
import java.util.List;

public class Leetcode_60 {
    public String getPermutation(int n, int k) {
        List<String> list = new ArrayList();
        StringBuilder str1 = new StringBuilder();
        List<Integer> num = new ArrayList();
        for (int i = 1; i <= n; i++) num.add(i);
        dfs1(list, str1, num, k);
        return list.get(list.size() - 1);
    }

    // AC 基本超时
    public boolean dfs1(List<String> res, StringBuilder str, List num, int k) {
        if (num.size() == 0) {
            res.add(str.toString());
            if (res.size() == k) return true;
            else return false;
        } else {
            int i = 0;
            while (i < num.size()) {
                int ele = (int) num.remove(i);
                if (!dfs1(res, str.append(ele), num, k)) {
                    str.deleteCharAt(str.toString().length() - 1);
                    num.add(i, ele);
                    i++;
                } else return true;
            }
            return false;
        }
    }

    /***
     * 想了半天数学方法总是有bug
     * @param n, k
     */
    public String mathMeth(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}

        k--;

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }

        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        Leetcode_60 o = new Leetcode_60();
        System.out.println(o.mathMeth(7, 68));
    }
}
