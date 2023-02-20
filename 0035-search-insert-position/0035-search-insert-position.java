class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo<hi){
            int mid = lo - (lo-hi)/2;
            
            if(nums[mid] == target){
                return mid;
            }
            else if(target>nums[mid]){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        if(target<=nums[lo]){
            return lo;
        }
        else{
            return lo+1;
        }
    }
}