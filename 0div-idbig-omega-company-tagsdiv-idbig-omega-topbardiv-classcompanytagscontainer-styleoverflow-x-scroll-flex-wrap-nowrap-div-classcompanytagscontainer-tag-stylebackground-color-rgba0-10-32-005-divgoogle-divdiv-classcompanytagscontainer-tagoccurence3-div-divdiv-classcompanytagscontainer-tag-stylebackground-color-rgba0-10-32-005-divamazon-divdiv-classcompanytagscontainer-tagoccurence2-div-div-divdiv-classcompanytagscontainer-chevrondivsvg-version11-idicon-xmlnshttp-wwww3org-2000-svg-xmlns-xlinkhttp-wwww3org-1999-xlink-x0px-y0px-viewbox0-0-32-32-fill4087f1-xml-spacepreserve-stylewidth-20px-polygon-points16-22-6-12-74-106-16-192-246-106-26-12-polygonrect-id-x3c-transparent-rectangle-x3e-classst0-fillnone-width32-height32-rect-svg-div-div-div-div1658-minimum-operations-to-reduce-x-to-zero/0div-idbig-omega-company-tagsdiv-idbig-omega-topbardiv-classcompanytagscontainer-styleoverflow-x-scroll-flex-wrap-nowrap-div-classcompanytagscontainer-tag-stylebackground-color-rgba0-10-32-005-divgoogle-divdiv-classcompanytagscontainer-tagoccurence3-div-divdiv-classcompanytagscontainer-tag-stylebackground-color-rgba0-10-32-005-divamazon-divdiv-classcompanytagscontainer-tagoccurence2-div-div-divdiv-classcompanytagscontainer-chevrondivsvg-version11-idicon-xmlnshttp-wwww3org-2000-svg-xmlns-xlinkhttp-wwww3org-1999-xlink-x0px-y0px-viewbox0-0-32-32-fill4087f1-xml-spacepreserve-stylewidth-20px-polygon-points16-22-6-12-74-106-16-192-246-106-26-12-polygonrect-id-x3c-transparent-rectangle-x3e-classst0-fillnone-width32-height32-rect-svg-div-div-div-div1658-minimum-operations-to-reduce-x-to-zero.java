class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for(int num:nums){
            target += num;
        }
        
        if(target == 0) return nums.length;
        if(target < 0) return -1;
        
        int res = -1;
        int left = 0;
        int ps = 0;
        
        for(int right = 0;right<nums.length;right++){
            ps += nums[right];
            
            while(ps > target){
                ps = ps-nums[left];
                left++;
            }
            
            if(ps == target){
                res = Math.max(res,right-left+1);
            }
        }
        
        return res == -1?-1:nums.length-res;
    }
}