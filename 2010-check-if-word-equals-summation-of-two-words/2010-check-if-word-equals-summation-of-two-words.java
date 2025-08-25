class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        Map<Character,String> map = new HashMap<>();
        String alpha = "abcdefghij";
        for(int i = 0;i<alpha.length();i++){
            map.put(alpha.charAt(i),Integer.toString(i));
        }
        int firstwordsum = 0 ;
        String firstword ="";
        for(int i = 0;i<firstWord.length();i++){
            firstword+=map.get(firstWord.charAt(i));
        }
        firstwordsum = Integer.parseInt(firstword);
        int secondwordsum = 0 ;
        String secondword ="";
        for(int i = 0;i<secondWord.length();i++){
            secondword+=map.get(secondWord.charAt(i));
        }
        secondwordsum = Integer.parseInt(secondword);
        int targetwordsum = 0 ;
        String targetword ="";
        for(int i = 0;i<targetWord.length();i++){
            targetword+=map.get(targetWord.charAt(i));
        }
        targetwordsum = Integer.parseInt(targetword);
        if(firstwordsum+secondwordsum==targetwordsum) return true;
        else return false;
        
    }
}