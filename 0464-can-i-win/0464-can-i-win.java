import java.util.*;

class Solution {
    Map<Integer, Boolean> memo = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) return false;  // impossible to reach
        if (desiredTotal <= 0) return true;

        return dfs(0, maxChoosableInteger, desiredTotal);
    }

    private boolean dfs(int used, int maxChoosable, int total) {
        if (memo.containsKey(used)) return memo.get(used);

        for (int i = 0; i < maxChoosable; i++) {
            int curBit = 1 << i;
            if ((used & curBit) != 0) continue; // already used

            // If picking i+1 wins immediately or leaves opponent losing
            if (total <= i + 1 || !dfs(used | curBit, maxChoosable, total - (i + 1))) {
                memo.put(used, true);
                return true;
            }
        }

        memo.put(used, false);
        return false;
    }
}
