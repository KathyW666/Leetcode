public class Leetcode_135 {
    /**
     * X 正向过一遍，反响过一遍，判断大的加和
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        int len = ratings.length;
        int[] candies = new int[len];
        for (int i = 0; i < len; i++) candies[i] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i-1]) candies[i] = candies[i-1]+1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                if (candies[i] > candies[i+1]) continue;
                else candies[i] = candies[i+1]+1;
            }
        }
        int res = 0;
        for (int n : candies) res+=n;
        return res;
    }

    public static void main(String[] args) {
        Leetcode_135 o = new Leetcode_135();
        int[] ratings = new int[]{1,2,87,87,87,2,1};
        System.out.println(o.candy(ratings));
    }
}
