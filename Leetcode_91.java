public class Leetcode_91 {
    //AC 更快？？
    public int numDecodings(String s) {
        if (s.length() == 1 && s.charAt(0) == '0') return 0;
        int[] total = new int[s.length()];
        if (s.charAt(0) == '0') total[0] = 0;
        else total[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '0' || s.charAt(i - 1) > '2') return 0;
                if (i == 1) total[i] = total[i - 1];
                else total[i] = total[i - 2];
            } else if (s.charAt(i - 1) == '0') total[i] = total[i - 1];
            else if (s.charAt(i - 1) == '1') total[i] = (i == 1) ? 2 : total[i - 1] + total[i - 2];
            else if (s.charAt(i - 1) == '2') {
                if (i == 1 && s.charAt(i) <= '6') total[i] = 2;
                else total[i] = (s.charAt(i) > '6') ? total[i - 1] : total[i - 1] + total[i - 2];
            } else total[i] = total[i - 1];
        }
        return total[s.length() - 1];
    }

    public int answer(String s) {
        if (s.length() == 0) return 0;
        int n = s.length();
        int[] count = new int[n + 1];
        count[n] = 1; //表示一个字符串
        count[n - 1] = (s.charAt(n - 1) == '0') ? 0 : 1;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            else {
                if (Integer.parseInt(s.substring(i, i + 2)) <= 26)
                    count[i] = count[i + 1] + count[i + 2];
                else count[i] = count[i + 1];
            }
        }
        return count[0];
    }

}
