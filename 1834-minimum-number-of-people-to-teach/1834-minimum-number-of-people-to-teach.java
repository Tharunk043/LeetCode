import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;  // number of people

        // Convert each person's languages to a Set for quick lookup
        List<Set<Integer>> personLanguages = new ArrayList<>();
        for (int[] langList : languages) {
            Set<Integer> set = new HashSet<>();
            for (int l : langList) set.add(l);
            personLanguages.add(set);
        }

        // Step 1: Find users that need teaching
        Set<Integer> needTeach = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1; // convert to 0-index
            int v = f[1] - 1;
            if (!canCommunicate(personLanguages.get(u), personLanguages.get(v))) {
                needTeach.add(u);
                needTeach.add(v);
            }
        }

        // If all friends can already communicate
        if (needTeach.isEmpty()) return 0;

        // Step 2: Try teaching each language
        int minTeach = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int countKnow = 0;
            for (int person : needTeach) {
                if (personLanguages.get(person).contains(lang)) {
                    countKnow++;
                }
            }
            // Remaining people must be taught
            minTeach = Math.min(minTeach, needTeach.size() - countKnow);
        }

        return minTeach;
    }

    private boolean canCommunicate(Set<Integer> a, Set<Integer> b) {
        for (int l : a) {
            if (b.contains(l)) return true;
        }
        return false;
    }
}
