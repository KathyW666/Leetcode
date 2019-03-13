import java.util.HashMap;
import java.util.Map;

/**
 * 判断点是否在同一条直线上，map套map，避免了用double
 */
public class Leetcode_149 {
    // 重复点case：[[1,1],[1,1],[2,2]]
    public int maxPoints(Point[] points) {
        if (points.length == 0) return 0;
        if (points.length <= 2) return points.length;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();    // 清空，以每个点为原点进行比较；
            int overlap = 0, max = 0;   // overlap 记录重复点;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int g = gcd(x, y);
                if (g != 0) {
                    x /= g;
                    y /= g;
                }
                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    } else map.get(x).put(y, 1);
                } else {
                    Map<Integer, Integer> m = new HashMap<>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            res = Math.max(res, max + overlap + 1);
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
}
