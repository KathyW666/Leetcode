import java.util.PriorityQueue;
import java.util.Scanner;

public class Tencent_A2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(in.hasNext()) {
            int n = in.nextInt();
            int k = in.nextInt();
            for (int i = 0; i < n; i++) {
                pq.add(in.nextInt());
            }
            StringBuilder sb = new StringBuilder();
            while (k >0) {
                if (pq.peek() != 0) {
                    int x = pq.poll();
                    sb.append(x);
                    sb.append(" ");
                    k--;
                    pq = minusX(pq, x);
                } else {
                    pq.poll();
                }
            }
            sb.delete(sb.length()-1, sb.length());
            System.out.println(sb.toString());
        }
    }
    public static PriorityQueue<Integer> minusX(PriorityQueue<Integer> pq, Integer x) {
        PriorityQueue<Integer> pqDup = new PriorityQueue<>();
        if (pq.isEmpty()) return pqDup;
        else {
            for (Integer n : pq) {
                pqDup.add(n-x);
            }
        }
        return pqDup;
    }

}
