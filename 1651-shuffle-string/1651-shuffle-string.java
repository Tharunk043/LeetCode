class Solution {
    public String restoreString(String s, int[] indices) {
        char[] ch = new char[s.length()];
        int ind = 0;
        for(int i:indices){
            ch[i] = s.charAt(ind++);
        }
        return new String(ch);

    }
}