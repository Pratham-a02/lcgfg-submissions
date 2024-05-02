class Solution{
    public int maximumCandies(int[] candies, long k) {
        int lo = 1;
        int max = 0;
        for(int val:candies){
            max = Math.max(max,val);
        }
        
        int hi = max;
        
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            
            if(solve(candies,k,mid)){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        return solve(candies,k,lo)?lo:(lo-1);
    }
    
    public boolean solve(int[] candies,long k,int mid){
        if(mid == 0) return true;
        long total = 0;
        for(int val:candies){
            total += (val/mid);
            if(total>=k){
                return true;
            }
        }
        return false;
    }
}