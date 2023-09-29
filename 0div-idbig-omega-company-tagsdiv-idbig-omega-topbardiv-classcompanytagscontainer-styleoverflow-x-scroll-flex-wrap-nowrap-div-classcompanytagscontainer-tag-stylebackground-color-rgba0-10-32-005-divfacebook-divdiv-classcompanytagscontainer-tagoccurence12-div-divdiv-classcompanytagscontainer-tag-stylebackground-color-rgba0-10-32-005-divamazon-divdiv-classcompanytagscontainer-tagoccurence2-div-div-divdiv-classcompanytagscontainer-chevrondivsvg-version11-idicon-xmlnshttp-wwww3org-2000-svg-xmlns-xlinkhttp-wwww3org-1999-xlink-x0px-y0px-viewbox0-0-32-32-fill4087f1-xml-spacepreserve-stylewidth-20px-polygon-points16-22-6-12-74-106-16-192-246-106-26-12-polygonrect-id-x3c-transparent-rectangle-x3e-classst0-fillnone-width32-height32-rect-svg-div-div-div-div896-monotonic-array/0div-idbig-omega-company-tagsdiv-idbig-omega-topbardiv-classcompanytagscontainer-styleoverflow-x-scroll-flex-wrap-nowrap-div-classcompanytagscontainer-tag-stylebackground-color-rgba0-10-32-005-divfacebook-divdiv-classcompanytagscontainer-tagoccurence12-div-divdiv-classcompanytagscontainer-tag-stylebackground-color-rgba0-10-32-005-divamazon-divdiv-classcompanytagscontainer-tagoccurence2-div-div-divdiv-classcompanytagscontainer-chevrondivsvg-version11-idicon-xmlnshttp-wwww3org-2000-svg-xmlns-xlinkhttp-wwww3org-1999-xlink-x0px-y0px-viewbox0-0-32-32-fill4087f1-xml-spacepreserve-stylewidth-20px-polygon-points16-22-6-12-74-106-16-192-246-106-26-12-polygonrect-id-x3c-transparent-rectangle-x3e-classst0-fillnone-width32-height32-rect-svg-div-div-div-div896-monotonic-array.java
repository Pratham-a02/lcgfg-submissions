class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean flag1 = true;
        boolean flag2 = true;
        
        for(int i = 1;i<nums.length;i++){
            if(nums[i]>=nums[i-1]){
                continue;
            }
            else{
                flag1 = false;
            }
        }
        
        for(int i = 1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                continue;
            }
            else{
                flag2 = false;
            }
        }
        
        return (flag1 || flag2);
    }
}