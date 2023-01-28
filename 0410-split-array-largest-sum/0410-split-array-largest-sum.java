class Solution {
    public int splitArray(int[] nums, int k) {
        int hi = 0;
        int lo = Integer.MIN_VALUE;
        for(int num:nums){
            hi+=num;
            lo = Math.max(lo,num);
        }
        
        while(lo<hi){
            int mid = (hi+lo)/2;
            int alsum = mid;
            
            int partitions = 1;
            int currsum = 0;
            
            for(int num:nums){
                if(currsum+num<=alsum){
                    currsum+=num;
                }
                else{
                    partitions++;
                    currsum = num;
                }
            }
            
            if(partitions <= k){
                hi = mid;
            }
            else{
                lo = mid+1;
            }
        }
        return lo;
    }
}