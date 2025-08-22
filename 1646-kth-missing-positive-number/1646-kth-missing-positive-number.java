class Solution {
    public int findKthPositive(int[] arr, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i :arr){
            al.add(i);
        }
        int res[] = new int[k];
        int i = 1;
        int j = 0;
        while(j<k){
            if(!al.contains(i)) res[j++] = i;
            i++;
        }
        return res[k-1];
    }
}