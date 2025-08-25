class Solution {
    public boolean isValid(String word) {
        if(word.length()<3) return false;
        boolean vowelscase = false;
        boolean consocase = false;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        for(char c :word.toCharArray()){
            if(!Character.isLetterOrDigit(c)) return false;
            if(Character.isLetter(c)){
                if(vowels.contains(c)) vowelscase = true;
                else consocase = true;
            }
        }
        return vowelscase && consocase;

        
    }
}