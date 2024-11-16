class Solution{
    public int[] resultsArray(int[] nums,int k){
        if(k == 1) return nums;
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int i = 0;
        int left = 0;
        int right = 1;
        Arrays.fill(ans,-1);
        while(right < n){
            if(nums[right-1]+1 != nums[right]){
                left = right;
            }
            if(right-left+1 == k){
                ans[left] = nums[right];
                left++;
            }
            right++;
        }
        
        
        return ans;
    }
}