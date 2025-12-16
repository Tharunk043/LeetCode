class Solution {
    public String maximumOddBinaryNumber(String s) {
        int one=0 ; int zero =0 ; 
        for(char c:s.toCharArray()){
            if(c=='0') zero++;
            else one++;
        }
        StringBuilder sb =new StringBuilder();
        for(int i =0;i<one-1;i++){
            sb.append("1");
        }
        for(int i = 0;i<zero;i++){
            sb.append("0");
        }
        sb.append("1");
        return sb.toString();
    }
}