class Solution {
    public int[] findErrorNums(int[] nums) {
        int rep = repeatingNumber(nums);
        int mis = missingNumber(nums);
        return new int[]{rep,mis};
    }
    
    public int repeatingNumber(int[] nums){
        for(int i = 0;i<nums.length;i++){
            int val = Math.abs(nums[i]);
            int idx = val-1;
            if(nums[idx]>0){
                nums[idx] = -1*nums[idx];
            }
            else{
                return val;
            }
        }
        return -1;
    }
    
    public int missingNumber(int[] nums){
        for(int i = 0;i<nums.length;i++){
            int val = Math.abs(nums[i]);
            int idx = val-1;
            if(nums[idx]<0){
                continue;
            }
            else{
                nums[idx] = -1*nums[idx];
            }
        }
        
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>0){
                return (i+1);
            }
        }
        return 0;
    }
}