class Solution{
    public int largestSumAfterKNegations(int[] nums,int k){
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<0 && k>0){
                nums[i] = (-1*nums[i]);
                k--;
            }
        }
        
        int sum = 0;
        for(int val:nums){
            sum += val;
        }
        
        int min = Integer.MAX_VALUE;
        for(int val:nums){
            min = Math.min(min,val);
        }
        
        if(k%2 == 1){
            sum = sum - 2*min;
        }
        return sum;
    }
}