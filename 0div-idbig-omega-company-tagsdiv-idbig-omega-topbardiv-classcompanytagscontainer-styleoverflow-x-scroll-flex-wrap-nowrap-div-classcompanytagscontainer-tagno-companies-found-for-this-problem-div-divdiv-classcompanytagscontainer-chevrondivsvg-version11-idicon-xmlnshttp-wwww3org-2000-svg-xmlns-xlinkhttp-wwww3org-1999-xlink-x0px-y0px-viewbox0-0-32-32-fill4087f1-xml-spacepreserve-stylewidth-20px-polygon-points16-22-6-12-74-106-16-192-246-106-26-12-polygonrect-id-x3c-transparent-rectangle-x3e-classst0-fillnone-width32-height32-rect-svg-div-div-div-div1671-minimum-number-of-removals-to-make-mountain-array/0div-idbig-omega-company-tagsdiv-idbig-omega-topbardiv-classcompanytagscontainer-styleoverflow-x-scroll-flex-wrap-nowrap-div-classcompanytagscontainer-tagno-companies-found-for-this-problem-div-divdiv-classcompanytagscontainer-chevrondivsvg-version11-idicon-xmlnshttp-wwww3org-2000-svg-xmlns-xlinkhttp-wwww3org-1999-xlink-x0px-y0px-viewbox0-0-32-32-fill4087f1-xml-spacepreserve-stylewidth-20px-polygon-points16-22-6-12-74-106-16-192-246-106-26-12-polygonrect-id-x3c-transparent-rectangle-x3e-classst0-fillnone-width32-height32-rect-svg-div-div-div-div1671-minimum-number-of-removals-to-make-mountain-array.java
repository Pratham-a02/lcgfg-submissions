class Solution{
    public int minimumMountainRemovals(int[] nums){
        int max = 0;
        int n = nums.length;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        
        for(int i = 0;i<nums.length;i++){
            left[i] = 1;
            for(int j = i-1;j>=0;j--){
                if(nums[j] < nums[i]){
                    left[i] = Math.max(left[i],1+left[j]);
                }
            }
        }
        
        for(int i = n-1;i>=0;i--){
            right[i] = 1;
            for(int j = i+1;j<n;j++){
                if(nums[i]>nums[j]){
                    right[i] = Math.max(right[i],1+right[j]);
                }
            }
        }
        
        for(int i = 0;i<n;i++){
            if(left[i]>1 && right[i]>1){
                int len = left[i] + right[i] - 1;
                max = Math.max(max,len);
            }
        }
        
        return n - max;
    }
}