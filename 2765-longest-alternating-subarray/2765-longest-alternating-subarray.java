class Solution {
    public int alternatingSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        for(int i = 0;i<nums.length;i++){
            int val = solve(i,true,nums);
            
            val = (val == 0)?val:val+1;
            max = Math.max(max,val);
        }
        
        if(max == Integer.MIN_VALUE || max == 0){
            return -1;
        }
        return max;
    }
    
    public int solve(int idx,boolean flag,int[] nums){
        if(idx == nums.length){
            return 0;
        }
        
        if(flag){
            if(idx+1<nums.length && nums[idx+1] - nums[idx] == 1){
                return 1 + solve(idx+1,false,nums);
            }
            else{
                return 0;
            }
        }
        else{
            if(idx+1<nums.length && nums[idx+1] - nums[idx] == -1){
                return 1 + solve(idx+1,true,nums);
            }
            else{
                return 0;
            }
        }
    }
}