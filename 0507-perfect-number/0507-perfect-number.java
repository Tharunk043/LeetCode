class Solution {
    public boolean checkPerfectNumber(int num) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1;i<num;i++){
            if(num%i==0) res.add(i);
        }
        int sum = 0;
        for(int i:res){
            sum+=i;
        }
        return sum==num;
    }
}