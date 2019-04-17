import java.util.Collections;
import java.util.LinkedList;

public class Leetcode_502 {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int count = 0;
        int allNum = Capital.length;
        if (allNum == 0) return W;
        LinkedList<Integer> profits = new LinkedList<Integer>();
        LinkedList<Integer> capital = new LinkedList<Integer>();
        for (int i = 0; i < allNum; i++) {
            profits.add(Profits[i]);
            capital.add(Capital[i]);
        }
        while (count < k && !capital.isEmpty()) {
            int tempMax = 0;
            int id = 0;
            for (int i = 0; i < allNum - count; i++) {
                if (W >= capital.get(i) && profits.get(i) > tempMax) {
                    tempMax = profits.get(i);
                    id = i;
                }
            }
            W += tempMax;
            profits.remove(id);
            capital.remove(id);
            count++;
        }
        return W;
    }


}
