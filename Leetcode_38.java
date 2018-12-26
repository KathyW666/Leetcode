public class Leetcode_38 {
    public String countAndSay(int n) {
        StringBuilder s = new StringBuilder("1");
        StringBuilder prev;
        char c;
        int count;
        for(int i = 1; i <n ; i++) {
            prev = s;
            s = new StringBuilder();
            count = 1;
            c = prev.charAt(0);

            for(int j = 1, len = prev.length(); j < len; j++ ) {
                if (prev.charAt(j) != c) {
                    s.append(count).append(c);
                    count = 1;
                    c = prev.charAt(j);
                }
                else count++;
            }
            s.append(count).append(c);
        }
        return s.toString();
    }
}
