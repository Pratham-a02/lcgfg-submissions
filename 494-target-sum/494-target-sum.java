class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return TotalWays(nums,target,0);
    }
    public int TotalWays(int[] nums,int target,int currIdx){
        if(currIdx>= nums.length && target == 0)
            return 1;
        if(currIdx>= nums.length && target!= 0)
            return 0 ;
        
        int pos = TotalWays(nums,target-nums[currIdx],currIdx+1);
        int neg = TotalWays(nums,target+nums[currIdx],currIdx+1);
        
        return pos+neg;
    }
}