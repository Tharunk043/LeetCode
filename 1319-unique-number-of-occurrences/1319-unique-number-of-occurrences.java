class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            if(map.containsKey(i)) map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        Set<Integer> occset = new HashSet<>();
        for(int i:map.values()){
            if(!occset.add(i)){
                return false;
            }
        }
        return true;
    }
}