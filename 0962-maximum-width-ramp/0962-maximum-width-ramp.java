class Solution{
    public int maxWidthRamp(int[] nums){
        int n = nums.length;
        int[] minfl = new int[nums.length];
        int[] maxfr = new int[nums.length];
        int max = 0;
        
        minfl[0] = nums[0];
        maxfr[n-1] = nums[n-1];
        
        for(int i = 1;i<n;i++){
            minfl[i] = Math.min(nums[i],minfl[i-1]);
        }
        
        for(int i = n-2;i>=0;i--){
            maxfr[i] = Math.max(nums[i],maxfr[i+1]);
        }
        
        int i = 0;
        int j = 0;
        
        while(j<n){
            if(minfl[i]<=maxfr[j]){
                max = Math.max(max,j-i);
                j++;
            }
            else{
                i++;
            }
        }
        return max;
    }
}