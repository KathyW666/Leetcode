import java.util.Comparator;
import java.util.List;

public class Leetcode_56 {
    /** AC 先依照start排序，再依次进行简单的比较
     * Definition for an interval.
     */

    class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            if (intervals.size() == 0 || intervals.size() == 1 || intervals == null)
                return intervals;
            intervals.sort(new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    if (o1.start < o2.start) return -1;
                    else if (o1.start > o2.start) return 1;
                    else return 0;
                }
            });
            int i = 0;
            while (i < intervals.size() - 1) {
                int s1 = intervals.get(i).start, e1 = intervals.get(i).end;
                int s2 = intervals.get(i + 1).start, e2 = intervals.get(i + 1).end;
                if (s2 > e1) i++;
                else {
                    intervals.remove(i);
                    Interval interval = new Interval(Math.min(s1, s2), Math.max(e1, e2));
                    intervals.set(i, interval);
                }
            }
            return intervals;
        }
    }
}
