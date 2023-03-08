class Solution {
    public int minEatingSpeed(int[] piles, int h){
        int lo = 1;
        int hi = 0;
        for(int pile:piles){
            hi = Math.max(hi,pile);
        }
        
        while(lo<hi){
            int as = (lo+hi)/2;
            
            int total = 0;
            for(int pile:piles){
                int time = (pile+as-1)/as;
                total+=time;
            }
            
            if(total>h){
                lo = as+1;
            }
            else{
                hi = as;
            }
        }
        
        return lo;
    }
}