class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums.length == 1){
            ans.add(nums[0]);
            return ans;
        }
        int tsum = 0;
        for(int val:nums){
            tsum += val;
        }
        Arrays.sort(nums);
        ans.add(nums[nums.length-1]);
        getList(nums,nums.length-1,nums[nums.length-1],ans,tsum);
        return ans;
    }
    
    public void getList(int[] nums,int idx,int currSum,List<Integer> ans,int tsum){
        if(currSum>tsum-currSum){
            return;
        }
        ans.add(nums[idx-1]);
        getList(nums,idx-1,currSum + nums[idx-1],ans,tsum);
    }
}