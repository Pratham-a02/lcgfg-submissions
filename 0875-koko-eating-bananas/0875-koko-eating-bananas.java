class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = Integer.MIN_VALUE;
        
        for(int pile:piles){
            hi = Math.max(hi,pile);
        }
        
        while(lo<hi){
            int mid = (lo+hi)/2;
            int currlimit = 0;
            for(int val:piles){
                currlimit += (val+mid-1)/mid;
            }
            
            if(currlimit>h){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        return lo;
    }
}