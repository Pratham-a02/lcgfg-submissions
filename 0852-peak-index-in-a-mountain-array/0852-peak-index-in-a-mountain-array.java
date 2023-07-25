class Solution{
    public int peakIndexInMountainArray(int[] nums){
        int lo = 0;
        int hi = nums.length-1;
        int n = nums.length;
        
        while(lo<hi){
         int mid = lo - (lo-hi)/2;
           if(mid == n-1 && nums[mid]>nums[mid-1]){
               return mid;
           }
           else if(mid == 0 && nums[mid]>nums[mid+1]){
               return mid;
           }
           else if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
               return mid;
           }
           else if(nums[mid+1]>nums[mid]){
               lo = mid+1;
           }
           else{
               hi = mid;
           }
        }
        return lo;
    }
}