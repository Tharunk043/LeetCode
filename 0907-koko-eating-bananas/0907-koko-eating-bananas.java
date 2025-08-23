class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minspeed = 1;
        int maxspeed = 0;
        for(int i:piles){
            maxspeed = Math.max(maxspeed,i);
        }
        while(minspeed<maxspeed){
            int mid = (minspeed+maxspeed)/2;
            if(caneat(piles,h,mid)) maxspeed = mid;
            else minspeed = mid+1;
        }
        return minspeed;
    }
    boolean caneat(int[] piles,int h,int speed){
        int hours = 0;
        for(int pi:piles){
            hours+=Math.ceil((double)pi/speed);
        }
        return hours<=h;
    }
}