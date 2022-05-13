class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        generateAllSubset(nums,0,new ArrayList<>(),powerSet);
        return powerSet;
    }
    
    private void generateAllSubset(int[] nums,int idx,List<Integer> currSubset, List<List<Integer>> powerSet){
        if(idx >= nums.length){
            powerSet.add(new ArrayList<>(currSubset));
            return;
        }
        int currVal = nums[idx];
        currSubset.add(currVal);
        generateAllSubset(nums,idx+1,currSubset,powerSet);
        
        currSubset.remove(currSubset.size() - 1);
        generateAllSubset(nums,idx+1,currSubset,powerSet);
        return;
    }
    
}