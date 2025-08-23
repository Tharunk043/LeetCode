class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] years = new int[2051]; // given constraint: 1950 <= year <= 2050

        // Mark birth and death
        for (int[] log : logs) {
            years[log[0]]++;    // born
            years[log[1]]--;    // died
        }

        int maxPop = 0, pop = 0, year = 1950;

        // Prefix sum over years
        for (int i = 1950; i <= 2050; i++) {
            pop += years[i];
            if (pop > maxPop) {
                maxPop = pop;
                year = i;
            }
        }

        return year;
    }
}
