import java.util.*;

public class Leetcode_127 {
    /**
     * beginWord "hit", endWord "cog" 找到最短变换序列的长度
     * 题目描述不太清晰，例：["hot","dot","dog","lot","log","cog"]
     * "hit" -> "hot" -> "dot" -> "dog" -> "cog" 5
     * 一开始还以为是按顺序...
     * 注意转换一次之后，可能有几个不同的word，用bfs
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        //用队列辅助BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        queue.add(null); //加入null来标记第几跳

        //HashSet储存已经标记过的word
        Set<String> marked = new HashSet<String>();
        marked.add(beginWord);

        int hop = 1;

        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (str != null) {
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String word = new String(chars);
                        if (word.equals(endWord)) return hop + 1;
                        if (wordList.contains(word) && !marked.contains(word)) {
                            queue.add(word);
                            wordList.remove(word);
                        }
                    }
                }
            } else {
                hop++;
                if (!queue.isEmpty()) queue.add(null);
            }
        }
        return 0;
    }

    public int hashSetMethod(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        //用HashSet辅助BFS
        Set<String> marked = new HashSet<>();
        marked.add(beginWord);

        int hop = 1;

        while(!marked.isEmpty()) {
            Set<String> toAdd = new HashSet<>();
            for (String str : marked) {
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String word = new String(chars);
                        if (word.equals(endWord)) return hop+1;
                        if (wordList.contains(word) && !toAdd.contains(word)) {
                            toAdd.add(word);
                            wordList.remove(word);
                        }
                    }
                }
            }
            hop++;
            if (toAdd.isEmpty()) break;
            marked = toAdd; //换到下一层
        }
        return 0;
    }
}
