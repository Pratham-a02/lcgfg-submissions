class Solution{
    public int longestAlternatingSubarray(int[] nums, int threshold){
       int ans = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] % 2 == 0 && nums[i] <= threshold){
                i += 1;
                int count = 1;
                while(i < nums.length){
                    if(nums[i - 1] % 2 == nums[i] % 2 || nums[i] > threshold) break;
                    i++;
                    count++;
                }
                i -= 1;
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}