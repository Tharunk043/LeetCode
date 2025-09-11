class Solution {
    public String sortVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        List<Character> vowelslist = new ArrayList<>();
        for(char c:s.toCharArray()){
            if(vowels.contains(c)) vowelslist.add(c);
        }
        Collections.sort(vowelslist);
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(char c:s.toCharArray()){
            if(vowels.contains(c)){
                sb.append(vowelslist.get(idx++));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}