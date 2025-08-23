class Solution {
    public int findKthPositive(int[] arr, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i:arr){
            al.add(i);
        }
        int res[] = new int[k];
        int num = 1;
        int i =0 ; 
        while(i<k){
            if(!al.contains(num)){
                res[i++] = num;
            }
            num++;
        }
        return res[k-1];
    }
}