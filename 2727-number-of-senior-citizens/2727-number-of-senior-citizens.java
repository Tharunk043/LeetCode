class Solution {
    public int countSeniors(String[] details) {
        int count=0;
        for(String str:details){
            String age = str.substring(11,13);
            int a = Integer.parseInt(age);
            if(a>60) count++;
        }
        return count;
    }
}