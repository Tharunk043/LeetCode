class Solution {
    public int maxRepeating(String sequence, String word) {
        int k = 0;
        StringBuilder sb = new StringBuilder(word);

        while (sequence.contains(sb.toString())) {
            k++;
            sb.append(word);  // add another repetition
        }

        return k;
    }
}
