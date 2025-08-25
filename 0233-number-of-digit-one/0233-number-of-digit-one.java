class Solution {
    public int countDigitOne(int n) {
        long pos = 1;   // start with ones place
        int count = 0;
        
        while (pos <= n) {
            long higher = n / (pos * 10);
            long curr = (n / pos) % 10;
            long lower = n % pos;
            
            if (curr == 0) {
                count += higher * pos;
            } else if (curr == 1) {
                count += higher * pos + (lower + 1);
            } else {
                count += (higher + 1) * pos;
            }
            
            pos *= 10;
        }
        return count;
    }
}
