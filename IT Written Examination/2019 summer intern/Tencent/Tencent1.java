import java.util.*;


public class Tencent1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int T = in.nextInt();
            for (int i = 0; i < T; i++) {
                int N = in.nextInt();
                int currN = N;
                PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
                for (int j = 0; j < N; j++) {
                    int a = in.nextInt();
                    pq.add(a);
                    if (pq.peek() == currN) {
                        StringBuilder sb = new StringBuilder();
                        while (!pq.isEmpty() && pq.peek() == currN) {
                            sb.append(pq.poll());
                            sb.append(" ");
                            currN--;
                        }
                        sb.delete(sb.length() - 1, sb.length());
                        System.out.println(sb.toString());
                    } else {
                        System.out.println();
                    }
                }

            }
        }
    }
}
