class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] res = new int[nums1.length+nums2.length];
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1]<=nums2[p2]){
                res[p3++] = nums1[p1++];
            }else{
                res[p3++] = nums2[p2++];
            }
        }
        while(p1<nums1.length){
            res[p3++] = nums1[p1++];
        }
        while(p2<nums2.length){
            res[p3++] = nums2[p2++];
        }
        if(res.length%2!=0){
            int mid = res.length/2;
            return res[mid];
        }
        int mid = res.length/2;
        return (res[mid]+res[mid-1])/2.0;

    }
}