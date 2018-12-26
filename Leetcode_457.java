import java.util.ArrayList;

public class Leetcode_457 {

    public class CircularArrayLoop457 {

        public int[] nums;

        public CircularArrayLoop457(int[] nums) {
            this.nums = nums;
        }

        public boolean circularArrayLoop(int[] nums) {
            int id = 0;
            int temp;
            ArrayList<Integer> index = new ArrayList<Integer>();
            boolean begin = true;
            while (id != 0 || begin) {
                temp = nums[id];
                if (sub(id + temp, nums.length) == id) {
                    if (id == 0)
                        return true;
                    return false;
                }
                id += temp;
                id = sub(id, nums.length);
                if (id == 0)
                    break;
                if (!begin) {
                    if (nums[id] * nums[0] < 0)
                        return false;
                }
                if (!index.contains(id))
                    index.add(id);
                else {
                    return false;
                }
                begin = false;
            }
            return true;
        }

        public int sub(int num, int n) {
            if (num >= n)
                num -= n;
            else if (num < 0)
                num += n;
            return num;
        }

    }
}
