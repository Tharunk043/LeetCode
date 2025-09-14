import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactSet = new HashSet<>();
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            exactSet.add(word);

            String lower = word.toLowerCase();
            caseMap.putIfAbsent(lower, word);

            String devowel = devowel(lower);
            vowelMap.putIfAbsent(devowel, word);
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            if (exactSet.contains(q)) {
                result[i] = q;
            } else {
                String lowerQ = q.toLowerCase();
                if (caseMap.containsKey(lowerQ)) {
                    result[i] = caseMap.get(lowerQ);
                } else {
                    String devowelQ = devowel(lowerQ);
                    result[i] = vowelMap.getOrDefault(devowelQ, "");
                }
            }
        }

        return result;
    }

    private String devowel(String word) {
        return word.replaceAll("[aeiou]", "#");
    }
}
