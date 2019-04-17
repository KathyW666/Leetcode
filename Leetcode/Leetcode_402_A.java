public class Leetcode_402_A {

    public String removeKdigits(String num, int k) {
        if (k == 0)
            return num;
        if (num.length() == 0 || num.length() == k)
            return "0";
        while (num.charAt(0) == '0') {
            num = delete(num, 0);
            if (num.length() <= k)
                return "0";
        }
        String res = num;
        for (int i = 0; i < num.length(); i++) {
            String delNum = delete(num, i);
            String ans = removeKdigits(delNum, --k);
            if (res.length() > ans.length())
                res = ans;
            if ((res.length() == ans.length()) && (res.compareTo(ans) > 0))
                res = ans;
            ++k;
        }
        while ((res.length() > 1) && (res.charAt(0) == '0'))
            res = delete(res, 0);
        return res;
    }


    public String delete(String str, int i) {
        return str.substring(0, i) + str.substring(i + 1, str.length());
    }
}
