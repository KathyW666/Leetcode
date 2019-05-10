import java.util.*;

/**
 * 从小到大排序，先放入小的值
 * 在oj上显示的答案和IDE中不一样
 */
public class Leetcode_406 {

    public static void main(String[] args) {
        int[][] people = new int[][]{{2, 4}, {3, 4}, {9, 0}, {0, 6}, {7, 1}, {6, 0}, {7, 3}, {2, 5}, {1, 1}, {8, 0}};
        int m = people.length, n = people[0].length;
        int[][] res = new int[m][n];

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(people[i]);
        }
        list.sort(new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                if (a1[0] == a2[0]) return a1[1] - a2[1];
                return a1[0] - a2[0];
            }
        });
        boolean[] isFull = new boolean[m];
        for (int[] a : list) {
            int id = a[1];
            int i = 0;
            for (int j = 0; j < m; j++) {
                if (!isFull[j]) {
                    if (i == id) {
                        res[j][0] = a[0];
                        res[j][1] = a[1];
                        isFull[j] = true;
                        break;
                    }
                    i++;
                } else if (res[j][0] == a[0]) i++;
            }

        }
        // print res[][]
        for (int[] b : res) {
            for (int num : b) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

/**
 * 答案方法
 */
//        if (people == null || people.length == 0 || people[0].length == 0)
//            return new int[0][0];
//
//        Arrays.sort(people, new Comparator<int[]>() {
//            public int compare(int[] a, int[] b) {
//                if (b[0] == a[0]) return a[1] - b[1];
//                return b[0] - a[0];
//            }
//        });
//
//        int n = people.length;
//        ArrayList<int[]> tmp = new ArrayList<>();
//        for (int i = 0; i < n; i++)
//            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});
//
//        int[][] res = new int[people.length][2];
//        int i = 0;
//        for (int[] k : tmp) {
//            res[i][0] = k[0];
//            res[i++][1] = k[1];
//        }
//
//        return res;
    }
}
