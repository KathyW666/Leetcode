import java.util.ArrayList;
import java.util.List;

public class Leetcode_68 {
    /** 想了一下思路没做
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int id = 0;
        while (id < words.length) {
            int count = words[id].length();
            int last = id + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth)
                    break;
                count += words[last].length() + 1;
                last++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[id]);
            int rest = last - id - 1;
            if (last == words.length || rest == 0) {
                for (int i = id + 1; i < last; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            }
            else {
                int spaces = (maxWidth - count) / rest;
                int r = (maxWidth - count) % rest;
                for (int i = id + 1; i < last; i++) {
                    for (int k = spaces; k > 0; k--) {
                        sb.append(" ");
                    }
                    if (r > 0) {
                        sb.append(" ");
                        r--;
                    }
                    sb.append(" ");
                    sb.append(words[i]);
                }
            }
            lines.add(sb.toString());
            id = last;
        }
        return lines;
    }
}
