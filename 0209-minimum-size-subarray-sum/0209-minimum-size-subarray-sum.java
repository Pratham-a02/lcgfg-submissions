class Solution{
    public int minSubArrayLen(int target,int[] nums){
        int min = Integer.MAX_VALUE;
        int left = 0;
        int ps = 0;
        for(int right = 0;right<nums.length;right++){
            ps += nums[right]; 
            
            if(ps >= target){
                while(ps >= target){
                    min = Math.min(min,right-left+1);
                    ps = ps - nums[left];
                    left++;
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
}