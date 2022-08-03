class Solution {
    public int maxSubArray(int[] nums) {
       int sum=0; 
       int Maxsum=Integer.MIN_VALUE; 
       for(int i=0;i<nums.length;i++)
       {
           sum=Math.max(sum+nums[i],nums[i]);
           Maxsum=Math.max(Maxsum,sum);
           
       }
       return Maxsum;
    }
}