class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] countSecret = new int[10];
        int[] countGuess = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                bulls++;
            } else {
                countSecret[s - '0']++;
                countGuess[g - '0']++;
            }
        }

        // Cows = min of available counts in both
        for (int d = 0; d < 10; d++) {
            cows += Math.min(countSecret[d], countGuess[d]);
        }

        return bulls + "A" + cows + "B";
    }
}
