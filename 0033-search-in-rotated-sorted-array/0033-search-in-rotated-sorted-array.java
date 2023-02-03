class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo<hi){
            int mid = lo - (lo-hi)/2;
            
            if(nums[hi]>nums[mid]){
                hi = mid;
            }
            else{
                lo = mid+1;
            }
        }
        int one = func(nums,0,lo-1,target);
        int two = func(nums,lo,nums.length-1,target);
        if(one == -1){
            return two;
        }
        else{
            return one;
        }
    }
    
    public int func(int[] nums,int lo,int hi,int x){
        while(lo<=hi){
            int mid  = lo - (lo-hi)/2;
            
            if(nums[mid] == x){
                return mid;
            }
            if(nums[mid] > x){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        
        return -1;
    }
}