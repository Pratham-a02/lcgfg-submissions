class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currAns = new ArrayList<>();
        helper(candidates,ans,currAns,0,target);
        return ans;
    }
    
    public void helper(int[] nums,List<List<Integer>> ans,List<Integer> currAns,int currIdx,int target){
        if(target == 0){
            List<Integer> base = new ArrayList<>(currAns);
            ans.add(base);
            return;
        }
        if(currIdx>= nums.length)
            return;
        
        if(target-nums[currIdx]>=0){
            currAns.add(nums[currIdx]);
            helper(nums,ans,currAns,currIdx,target-nums[currIdx]);
            currAns.remove(currAns.size()-1);
        }
        helper(nums,ans,currAns,currIdx+1,target);
        return;
    }
}