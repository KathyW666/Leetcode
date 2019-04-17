import java.util.Scanner;

public class Tencent_A1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int K = in.nextInt();
            int ans = 0, i = 0, n = N;
            while(n > 0) {
                ans++;
                double powNum = Math.pow(2.0, i);
                if (K >= powNum) {
                    K -= powNum;
                    i++;
                    if (n % 2 == 0) n = n / 2;
                    else n = n / 2 + 1;
                } else n--;
            }
            System.out.println(ans);
        }
    }
}
