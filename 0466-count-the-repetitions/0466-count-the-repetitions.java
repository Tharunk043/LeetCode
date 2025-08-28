class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) return 0;

        int len1 = s1.length(), len2 = s2.length();
        int index2 = 0, count2 = 0; 

        // Maps: how many times s2 is matched after finishing i-th s1
        int[] indexRecorder = new int[n1 + 1];
        int[] countRecorder = new int[n1 + 1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 0; j < len1; j++) {
                if (s1.charAt(j) == s2.charAt(index2)) {
                    index2++;
                    if (index2 == len2) { // one s2 finished
                        index2 = 0;
                        count2++;
                    }
                }
            }
            indexRecorder[i] = index2;
            countRecorder[i] = count2;

            // detect cycle
            for (int k = 0; k < i; k++) {
                if (indexRecorder[k] == index2) {
                    // found a loop between k and i
                    int preCount = countRecorder[k];
                    int patternCount = ((n1 - k) / (i - k)) * (count2 - countRecorder[k]);
                    int remainCount = countRecorder[k + (n1 - k) % (i - k)] - countRecorder[k];
                    return (preCount + patternCount + remainCount) / n2;
                }
            }
        }
        return count2 / n2;
    }
}
