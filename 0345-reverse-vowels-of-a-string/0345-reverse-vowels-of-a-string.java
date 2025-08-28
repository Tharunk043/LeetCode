class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');
        set.add('A'); set.add('E'); set.add('I'); set.add('O'); set.add('U');

        int left = 0, right = s.length() - 1;
        char[] ch = s.toCharArray();

        while (left < right) {
            if (!set.contains(ch[left])) {
                left++;
            } else if (!set.contains(ch[right])) {
                right--;
            } else {
                // both are vowels → swap
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
        }

        return new String(ch);
    }
}
