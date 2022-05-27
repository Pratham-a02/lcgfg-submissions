class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        boolean[] vis = new boolean[nums.length];
        generateAns(nums,vis,new ArrayList<>(),ans);
        return new ArrayList(ans);
    }
    
    private void generateAns(int[] nums,boolean[] vis,List<Integer> subset, Set<List<Integer>> ans){
        if(subset.size() == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        
        for(int i = 0;i<nums.length;i++){
            if(vis[i] == false){
                vis[i] = true;
                subset.add(nums[i]);
                generateAns(nums,vis,subset,ans);
                subset.remove(subset.size() - 1);
                vis[i] = false;
            }
        }
    }
    
}