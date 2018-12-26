import java.util.HashMap;
import java.util.LinkedHashSet;
public class Leetcode_460 {
    public class LFUCache460 {
        HashMap<Integer, Integer> vals;
        HashMap<Integer, Integer> counts;
        HashMap<Integer, LinkedHashSet<Integer>> lists;
        int cap;
        int min = -1;

        public LFUCache460(int capacity) {
            cap = capacity;
            vals = new HashMap<>();
            counts = new HashMap<>();
            lists = new HashMap<>();
            lists.put(1, new LinkedHashSet<>());
        }

        public int get(int key) {
            if (!vals.containsKey(key)) return -1;
            int count = counts.get(key);
            counts.put(key, count+1);
            lists.get(count).remove(key);
            if (count == min && lists.get(count).size() == 0)
                min++;
            if (!lists.containsKey(count+1))
                lists.put(count+1, new LinkedHashSet<>());
            lists.get(count+1).add(key);
            return vals.get(key);

        }

        public void put(int key, int value) {
            if(cap<=0) return;
            if(vals.containsKey(key)) {
                vals.put(key, value);
                get(key);
                return;
            }
            if(vals.size() >= cap) {
                int evit = lists.get(min).iterator().next();
                //第一次调用iterator的next()，返回序列的第一个元素
                lists.get(min).remove(evit);
                vals.remove(evit);
            }
            vals.put(key, value);
            counts.put(key,1);
            min = 1;
            lists.get(1).add(key);

        }
    }

}
