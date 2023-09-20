class Solution {
    public int[] searchRange(int[] nums, int target) {
        int fi = -1;
        int li = -1;
        
        int lo = 0;
        int hi = nums.length -1;
        
        while(lo<=hi){
            int mid = lo - (lo-hi)/2;
            
            if(nums[mid] == target){
                fi = mid;
                hi = mid-1;
            }
            else if(nums[mid]>target){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        
        lo = 0;
        hi = nums.length -1;
        
        while(lo<=hi){
            int mid = lo - (lo-hi)/2;
            
            if(nums[mid] == target){
                li = mid;
                lo = mid+1;
            }
            else if(nums[mid]>target){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return new int[]{fi,li};
    }
}