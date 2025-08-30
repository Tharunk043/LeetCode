class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int [][] res = new int[intervals.length+1][2];
        int i = 0;
        int j = 0;
        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            res[j++] = intervals[i++];
        }
        while(i<intervals.length && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i++][1],newInterval[1]);
        }
        res[j++] =newInterval;
        while(i<intervals.length){
            res[j++] = intervals[i++];
        }
        return Arrays.copyOf(res,j);
    }
}
