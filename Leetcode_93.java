import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_93 {
    /**
     * AC dfs 考虑很多边界情况
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0 || s.length() > 12) return res;
        dfs(res, s, new StringBuilder(), 0, 0);
        return res;
    }

    private void dfs(List<String> res, String s, StringBuilder sb, int id, int times) {
        if (times == 3) {
            String last = s.substring(id, s.length());
            if (Integer.parseInt(last) < 256 && last.charAt(0) != '0' || last.length() == 1) {
                sb.append(s.substring(id, s.length()));
                res.add(sb.toString());
                sb.delete(id + 3, sb.length());
            }
            return;
        }
        int i = 1;
        while (i <= 3 && id + i < s.length()) {
            if (Integer.parseInt(s.substring(id, id + i)) < 256) {
                if (i != 1 && s.substring(id, id + i).charAt(0) == '0') {
                    i++;
                    continue;
                }
                sb.append(s.substring(id, id + i));
                sb.append('.');
                dfs(res, s, sb, id + i, times + 1);
                sb.delete(sb.length() - i - 1, sb.length());
            }
            i++;
        }
    }

    private List<String> answer(String s) {
        List<String> res = new LinkedList<>();
        if (s.length() > 12 || s.length() < 4) return res;
        for (int a = 1; a <= 3; a++)
            for (int b = 1; b <= 3; b++)
                for (int c = 1; c <= 3; c++)
                    for (int d = 1; d <= 3; d++)
                        if (a + b + c + d == s.length()) {
                            String A = s.substring(0, a);
                            String B = s.substring(a, a + b);
                            String C = s.substring(a + b, a + b + c);
                            String D = s.substring(a + b + c, a + b + c + d);
                            if (A.charAt(0) == '0' && a > 1) break;
                            if (B.charAt(0) == '0' && b > 1) break;
                            if (C.charAt(0) == '0' && c > 1) break;
                            if (D.charAt(0) == '0' && d > 1) break;
                            if (Integer.valueOf(A) < 256 && Integer.valueOf(B) < 256 &&
                                    Integer.valueOf(C) < 256 && Integer.valueOf(D) < 256) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(A);
                                sb.append('.');
                                sb.append(B);
                                sb.append('.');
                                sb.append(C);
                                sb.append('.');
                                sb.append(D);
                                res.add(sb.toString());
                            }

                        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode_93 o = new Leetcode_93();
        String s = "010010";
        System.out.println(o.restoreIpAddresses(s));
        System.out.println(o.answer(s));
    }
}
