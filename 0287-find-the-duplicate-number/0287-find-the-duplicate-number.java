class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            int val = Math.abs(nums[i]);
            int idx = val-1;
            
            if(nums[idx] < 0){
                return idx+1;
            }
            nums[idx] = -1*nums[idx];
        }
        return 0;
    }
}