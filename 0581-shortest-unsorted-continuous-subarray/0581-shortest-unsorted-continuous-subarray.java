class Solution{
    public int findUnsortedSubarray(int[] nums){
        if(nums.length == 1){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(i == 0){
                if(nums[i]>nums[i+1]){
                    min = Math.min(min,nums[i]);
                    max = Math.max(max,nums[i]);
                }
            }
            else if(i == n-1){
                if(nums[i]<nums[i-1]){
                    min = Math.min(min,nums[i]);
                    max = Math.max(max,nums[i]);
                }
            }
            else{
                if(nums[i]<nums[i-1]  || nums[i]>nums[i+1]){
                    min = Math.min(min,nums[i]);
                    max = Math.max(max,nums[i]);
                }
            }
        }
        if(min == Integer.MAX_VALUE || max == Integer.MIN_VALUE){
            return 0;
        }
        int i = 0;
        int j = n-1;
        for(i = 0;i<n&&nums[i]<=min;i++){}
        for(j = n-1;j>=0&&nums[j]>=max;j--){}
        
        return (j-i+1);
    }
}