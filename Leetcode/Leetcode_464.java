import java.util.HashMap;

public class Leetcode_464 {

        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            if (desiredTotal <= 0)
                return true;
            if (((1+maxChoosableInteger)*maxChoosableInteger/2) < desiredTotal)
                return false;
            char[] state = new char[maxChoosableInteger];
            for(int i=0; i<state.length; i++)
                state[i] = '0';
            HashMap<String, Boolean> map = new HashMap<>();

            return dfs464(desiredTotal, state, map);
        }

        public boolean dfs464(int tempTarget, char[] state, HashMap<String, Boolean> map) {
            String key = new String(state);
            if (map.containsKey(key))
                return map.get(key);
            for(int i=0; i<state.length; i++) {
                if (state[i] == '0'){
                    state[i] = '1';
                    if (tempTarget <= i+1 || !dfs464(tempTarget-i-1, state, map)) {
                        map.put(key, true);
                        state[i] = '0';
                        return true;
                    }
                    state[i] = '0';
                }
            }
            map.put(key, false);
            return false;
        }

}
