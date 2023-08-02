class Solution{
    public List<List<Integer>> permute(int[] nums){
        boolean[] vis = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums,vis,ans,new ArrayList<>());
        return ans;
    }
    
    public void solve(int[] nums,boolean[] vis,List<List<Integer>> ans,List<Integer> curr){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = 0;i<nums.length;i++){
            if(vis[i] == false){
                curr.add(nums[i]);
                vis[i] = true;
                solve(nums,vis,ans,curr);
                vis[i] = false;
                curr.remove(curr.size()-1);
            }
        }
    }
}