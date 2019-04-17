import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 字典排序，有bug，最后两个test没通过
 * 基本想法一样，有一些边界case欠考虑
 */
public class Leetcode_179 {
    public String myAnswer(int[] nums) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int n : nums) list.add(String.valueOf(n));
        list.sort(new Comparator<String>() {
            public int compare(String o1, String o2) {
                int i = 0, j = 0;
                while (i < o1.length() || j < o2.length()) {
                    if (i >= o1.length()) {
                        if (o1.charAt(0) >= o2.charAt(j)) return 1;
                        else return -1;
                    }
                    if (j >= o2.length()) {
                        if (o1.charAt(i) > o2.charAt(0)) return 1;
                        else return -1;
                    }
                    if (o1.charAt(i) < o2.charAt(j)) return -1;
                    else if (o1.charAt(i) > o2.charAt(j)) return 1;
                    else {i++; j++;}
                }
                return 0;
            }
        });
        while (!list.isEmpty()) {
            if (sb.length() == 0 && list.get(list.size()-1).equals("0"))
                list.remove(list.size()-1);
            else sb.append(list.remove(list.size()-1));
        }
        return sb.length() == 0 ? String.valueOf(0) : sb.toString();
    }

    public String answer(int[] nums) {
        if (nums.length == 0 || nums == null) return "";
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int num : nums) list.add(String.valueOf(num));
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });
        if (list.get(list.size()-1).equals("0")) return "0";
        while (!list.isEmpty())
            sb.append(list.remove(list.size()-1));
        return sb.toString();
    }
}
