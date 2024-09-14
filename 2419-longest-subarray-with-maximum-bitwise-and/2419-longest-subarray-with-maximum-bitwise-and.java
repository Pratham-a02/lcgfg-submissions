class Solution{
    public int longestSubarray(int[] nums){
        int max = 0;
        for(int num:nums){
            max = Math.max(max,num);
        }
        int ans = 0;
        int idx = 0;
        while(idx<nums.length){
            int cnt = 0;
            if(nums[idx] == max){
                int j = idx;
                while(j<nums.length && nums[j] == max){
                    cnt++;
                    j++;
                }
                idx = j;
                ans = Math.max(ans,cnt);
            }
            else{
                idx++;
            }
        }
        return ans;
    }
}