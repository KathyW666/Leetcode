import java.util.LinkedList;
import java.util.List;

public class Leetcode_89 {
    /** 忘光了数电
     * 格雷码
     * Gn-1= Bn-1
     * Gi = Bi 异或 Bi+1
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>(); //细节，适用于插入操作
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }

}
