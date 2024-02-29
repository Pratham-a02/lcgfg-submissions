class Solution{
    public int findPeakElement(int[] nums){
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo<hi){
            int mid = (lo+hi)/2;
            
            if(mid == 0 && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(mid == nums.length-1 && nums[mid]>nums[mid-1]){
                return mid;
            }
            else if(mid-1>=0 && nums[mid] > nums[mid-1] && mid+1<nums.length && nums[mid] > nums[mid+1]){
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