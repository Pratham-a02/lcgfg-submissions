class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        generateAns(nums,vis,new ArrayList<>(),ans);
        return ans;
    }
    
    private void generateAns(int[] nums,boolean[] vis,List<Integer> subset,List<List<Integer>> powerSet){
        if(subset.size() == nums.length){
            powerSet.add(new ArrayList<>(subset));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(vis[i] == false){
                vis[i] = true;
                subset.add(nums[i]);
                generateAns(nums,vis,subset,powerSet);
                subset.remove(subset.size() - 1);
                vis[i] = false;
            }
        }
        
    }
    
}