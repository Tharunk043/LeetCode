import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> freq = new HashMap<>();

        // Normalize: lowercase + replace non-letters with space
        String[] words = paragraph.toLowerCase().replaceAll("[^a-z]", " ").split("\\s+");

        for (String word : words) {
            if (word.isEmpty() || bannedSet.contains(word)) continue;
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        // Find max frequency
        String ans = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                ans = entry.getKey();
            }
        }

        return ans;
    }
}
