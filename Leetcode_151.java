public class Leetcode_151 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        String[] strings = s.trim().split(" ");
        // String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i] != " ") sb.append(strings[i]);
            if (i != 0) sb.append(' ');
        }
        s = sb.toString();
        // for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) == ' ') {
        //         s = s.substring(0, i) + s.substring(i+1);
        //         i--;
        //     }
        //     else break;
        // }
        // for (int i = s.length()-1; i >=0; i--) {
        //     if (s.charAt(i) == ' ') {
        //         s = s.substring(0, i);
        //     }
        //     else break;
        // }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && s.charAt(i - 1) == ' ') {
                s = s.substring(0, i - 1) + s.substring(i);
                i--;
            }
        }
        return s;
    }

}
