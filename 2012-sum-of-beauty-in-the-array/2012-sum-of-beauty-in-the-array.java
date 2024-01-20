class Solution{
    public int sumOfBeauties(int[] nums){
        int n = nums.length;
        int[] minfromRight = new int[nums.length+1];
        int[] maxfromLeft = new int[nums.length+1];
        maxfromLeft[0] = nums[0];
        minfromRight[n-1] = nums[n-1];
        
        for(int i = 1;i<n;i++){
            maxfromLeft[i] = Math.max(nums[i],maxfromLeft[i-1]);
        }
        
        for(int i = n-2;i>=0;i--){
            minfromRight[i] = Math.min(nums[i],minfromRight[i+1]);
        }
        
        int ans = 0;
        
        for(int i = 1;i<n-1;i++){
            if(nums[i]>maxfromLeft[i-1] && nums[i]<minfromRight[i+1]){
                ans+=2;
            }    
            else if(nums[i]>nums[i-1] && nums[i]<nums[i+1]){
                ans += 1;
            }
        }
        
        return ans;
    }
}