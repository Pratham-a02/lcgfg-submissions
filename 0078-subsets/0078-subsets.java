class Solution{
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        solve(0,new ArrayList<>(),ans,nums);
        return ans;
    }
    
    public void solve(int idx,List<Integer> curr,List<List<Integer>> ans,int[] nums){
        if(idx>=nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        solve(idx+1,curr,ans,nums);
        curr.remove(curr.size()-1);
        solve(idx+1,curr,ans,nums);
        
        return;
    }
}