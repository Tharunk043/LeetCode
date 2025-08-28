import java.util.*;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        
        List<String> res = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        
        for (int j = 0; j < list2.length; j++) {
            String rest = list2[j];
            if (map.containsKey(rest)) {
                int sum = j + map.get(rest);
                
                if (sum < minSum) {
                    res.clear();
                    res.add(rest);
                    minSum = sum;
                } else if (sum == minSum) {
                    res.add(rest);
                }
            }
        }
        
        return res.toArray(new String[0]);
    }
}
