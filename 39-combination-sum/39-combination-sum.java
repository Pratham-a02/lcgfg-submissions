class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> powerSet = new ArrayList<>();
        coinChange(candidates,target,0,new ArrayList<>(),powerSet);
        return powerSet;
    }
    
    private void coinChange(int[] candidates, int target,int idx,List<Integer> subset, List<List<Integer>> powerSet){
        if(target == 0){
            powerSet.add(new ArrayList<>(subset));
            return;
        }
        if(idx >= candidates.length){
            return;
        }
        int currVal = candidates[idx];
        if(target-currVal >= 0){
            subset.add(currVal);
            coinChange(candidates,target-currVal,idx,subset,powerSet);
            // subset.remove(currVal);
            subset.remove(subset.size()-1);
        }
        // subset.remove(subset.size()-1);
        coinChange(candidates,target,idx+1,subset,powerSet);
        return;
    }
    
}