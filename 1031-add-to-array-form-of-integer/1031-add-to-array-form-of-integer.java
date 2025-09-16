import java.util.*;
import java.math.BigInteger;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int p = num.length - 1;
        StringBuilder sb = new StringBuilder();
        for (int i : num) {
            sb.append(i);
        }

        // Use BigInteger to avoid overflow
        BigInteger n = new BigInteger(sb.toString());
        n = n.add(BigInteger.valueOf(k));

        List<Integer> rev = new ArrayList<>();
        String s = n.toString();
        for (char c : s.toCharArray()) {
            rev.add(c - '0');
        }

        return rev;
    }
}
