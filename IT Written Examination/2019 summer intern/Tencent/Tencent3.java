import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Tencent3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int res = 0;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n * 2; i++) {
            list.add(i+1);
        }
        helper(list, k,res);
        System.out.println(res);
    }

    public static void helper(List<Integer> list, int k, int res) {
        if (list.size() == 0) {
            res++;
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (Math.abs(list.get(i)-list.get(j)) < k) continue;
                int currI = list.get(i);
                int currJ = list.get(j);
                list.remove(i);
                list.remove(j);
                helper(list, k , res);
                list.add(currI);
                list.add(currJ);
                Collections.sort(list);
            }
        }

    }
}
