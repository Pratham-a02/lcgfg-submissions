class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        if(nums.length == 1){
            return nums[0];
        }
        else if(nums[0] != nums[1]){
            return nums[0];
        }
        else if(nums[nums.length-1] != nums[nums.length-2]){
            return nums[nums.length-1];
        }
        while(lo<=hi){
            int mid = lo - (lo-hi)/2;
            
            if(mid - 1>=0 && mid+1<nums.length){
                if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                    return nums[mid];
                }
            }
            
            if(mid+1 < nums.length && nums[mid] == nums[mid+1]){
                
                int rs = hi - mid+1;
                if(rs%2 == 0){
                    hi = mid-1;
                }
                else{
                    lo = mid+2;
                }
            }
            else if(mid -1 >= 0 && nums[mid] == nums[mid-1]){
                int ls = mid - lo + 1;
                
                if(ls%2 == 0){
                    lo = mid+1;
                }
                else{
                    hi = mid-2;
                }
            }
        }
        return nums[lo];
    }
}