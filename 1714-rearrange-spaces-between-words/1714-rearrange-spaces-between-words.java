class Solution {
    public String reorderSpaces(String text) {
        // Count total spaces
        int totalSpaces = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') totalSpaces++;
        }

        // Split into words (using "\\s+" for regex)
        String[] words = text.trim().split("\\s+");
        int n = words.length;

        // If only one word, append all spaces at the end
        if (n == 1) {
            return words[0] + " ".repeat(totalSpaces);
        }

        // Distribute spaces evenly
        int spacesBetween = totalSpaces / (n - 1);
        int extraSpaces = totalSpaces % (n - 1);

        String separator = " ".repeat(spacesBetween);
        String result = String.join(separator, words);

        // Add leftover spaces at the end
        result += " ".repeat(extraSpaces);

        return result;
    }
}
