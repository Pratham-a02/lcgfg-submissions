class Solution{
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        solve(new ArrayList<>(),nums,vis,ans);
        return ans;
    }
    
    public void solve(List<Integer> curr,int[] nums,boolean[] vis,List<List<Integer>> ans){
        if(curr.size() == nums.length){
            List<Integer> al = new ArrayList<>(curr);
            if(!ans.contains(al)){
                ans.add(al);
            }
            return;
        }
        
        for(int i = 0;i<nums.length;i++){
            if(vis[i] == false){
                vis[i] = true;
                curr.add(nums[i]);
                solve(curr,nums,vis,ans);
                vis[i] = false;
                curr.remove(curr.size()-1);
            }
        }
    }
}