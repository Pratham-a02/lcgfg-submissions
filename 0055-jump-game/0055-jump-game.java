class Solution {
    public boolean canJump(int[] nums) {
        int idx = nums.length-1;
        
        
        for(int i = nums.length-1;i>=0;i--){
            if(nums[i] + i >= idx){
                idx = i;
            }
        }
        
        if(idx == 0){
            return true;
        }
        else{
            return false;
        }
    }
}