class Solution{
    public int[] resultsArray(int[] nums,int k){
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int i = 0;
        int left = 0;
        for(int right = 0;right<n;right++){
            int max = 0;
            if(right-left+1 == k){
                max = Math.max(max,nums[left]);
                int idx = left+1;
                while(idx<=right){
                    max = Math.max(max,nums[idx]);
                    if(nums[idx] !=nums[idx-1]+1){
                        ans[i] = -1;
                        break;
                    }
                    idx++;
                }
                if(ans[i] != -1) ans[i] = max;
                i++;
                left++;
            }
        }
        return ans;
    }
}