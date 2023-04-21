class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0;i<numRows;i++){
            List<Integer> pAns = new ArrayList<>();
            for(int j = 0;j<=i;j++){
                if(j == 0 || j == i){
                    pAns.add(1);
                }
                else{
                    pAns.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));   
                }
            }
            ans.add(pAns);
        }
        
        return ans;
    }
}