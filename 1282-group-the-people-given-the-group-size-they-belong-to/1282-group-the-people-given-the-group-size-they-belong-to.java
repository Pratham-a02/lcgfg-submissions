class Solution{
    public List<List<Integer>> groupThePeople(int[] groupSizes){
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0;i<groupSizes.length;i++){
            int val = groupSizes[i];
            if(val == -1) continue;
            List<Integer> curr = new ArrayList<>();
            int currSize = val;
            
            for(int j = 0;currSize>0 && j<groupSizes.length;j++){
                if(groupSizes[j] != -1 && groupSizes[j] == val){
                    curr.add(j);
                    groupSizes[j] = -1;
                    currSize--;
                }
            }
            
            ans.add(curr);
        }
        return ans;
    }
}