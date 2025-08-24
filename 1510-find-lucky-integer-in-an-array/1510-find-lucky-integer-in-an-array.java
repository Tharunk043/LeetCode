class Solution {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i :arr){
            if(map.containsKey(i)) map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        Arrays.sort(arr);
        for(int i = arr.length-1;i>=0;i--){
            if(map.get(arr[i])==arr[i])
                return arr[i];
        }

        return -1;
    }
}