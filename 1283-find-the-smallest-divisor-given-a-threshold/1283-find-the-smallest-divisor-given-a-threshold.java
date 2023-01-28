class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1;
        int max = Integer.MIN_VALUE;
        for(int val:nums){
            max = Math.max(max,val);
        }
        int hi = max;
        
        while(lo<hi){
            int mid = (2*hi - (hi-lo))/2;
            int sum = 0;
            for(int val:nums){
                int quo = (val+mid-1)/mid;
                sum += quo;
            }
            
            if(sum>threshold){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        return lo;
    }
}