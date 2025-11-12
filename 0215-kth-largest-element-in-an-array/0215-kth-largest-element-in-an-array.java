class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> mh = new PriorityQueue<>();
        for(int i:nums){
            mh.add(i);
            if(mh.size()>k){
                mh.poll();
            }
        }
        return mh.peek();
    }
}