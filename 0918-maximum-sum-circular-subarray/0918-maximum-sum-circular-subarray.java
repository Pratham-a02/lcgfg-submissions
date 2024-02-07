class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        for(int num:nums){
            total += num;
        }
        
        int normal = kadaneAlgo(nums);
        int abNormal = total - minKadane(nums);
        
        if(abNormal == 0){
            return normal;
        }
        
        return Math.max(normal,abNormal);
    }
    
    public int minKadane(int[] nums){
        int min = Integer.MAX_VALUE;
        int currSum = 0;
        
        for(int i = 0;i<nums.length;i++){
            currSum += nums[i];
            min = Math.min(min,currSum);
            
            if(currSum>0){
                currSum = 0;
            }
        }
        return min;
    }
    
    public int kadaneAlgo(int[] nums){
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0;i<nums.length;i++){
            currSum += nums[i];
            max = Math.max(max,currSum);
            
            if(currSum<0){
                currSum = 0;
            }
        }
        return max;
    }
}