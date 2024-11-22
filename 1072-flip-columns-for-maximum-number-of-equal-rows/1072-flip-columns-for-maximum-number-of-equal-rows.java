class Solution{
    public int maxEqualRowsAfterFlips(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(int[] mat:matrix){
            StringBuilder currVal = new StringBuilder();
            StringBuilder newVal = new StringBuilder();
            
            for(int val:mat){
                currVal.append(val);
                newVal.append(1-val);
            }
            
            hm.put(currVal.toString(),hm.getOrDefault(currVal.toString(),0)+1);
            hm.put(newVal.toString(),hm.getOrDefault(newVal.toString(),0)+1);
        }
        
        int ans = 0;
        
        for(int val:hm.values()){
            ans = Math.max(ans,val);
        }
        return ans;
    }
}