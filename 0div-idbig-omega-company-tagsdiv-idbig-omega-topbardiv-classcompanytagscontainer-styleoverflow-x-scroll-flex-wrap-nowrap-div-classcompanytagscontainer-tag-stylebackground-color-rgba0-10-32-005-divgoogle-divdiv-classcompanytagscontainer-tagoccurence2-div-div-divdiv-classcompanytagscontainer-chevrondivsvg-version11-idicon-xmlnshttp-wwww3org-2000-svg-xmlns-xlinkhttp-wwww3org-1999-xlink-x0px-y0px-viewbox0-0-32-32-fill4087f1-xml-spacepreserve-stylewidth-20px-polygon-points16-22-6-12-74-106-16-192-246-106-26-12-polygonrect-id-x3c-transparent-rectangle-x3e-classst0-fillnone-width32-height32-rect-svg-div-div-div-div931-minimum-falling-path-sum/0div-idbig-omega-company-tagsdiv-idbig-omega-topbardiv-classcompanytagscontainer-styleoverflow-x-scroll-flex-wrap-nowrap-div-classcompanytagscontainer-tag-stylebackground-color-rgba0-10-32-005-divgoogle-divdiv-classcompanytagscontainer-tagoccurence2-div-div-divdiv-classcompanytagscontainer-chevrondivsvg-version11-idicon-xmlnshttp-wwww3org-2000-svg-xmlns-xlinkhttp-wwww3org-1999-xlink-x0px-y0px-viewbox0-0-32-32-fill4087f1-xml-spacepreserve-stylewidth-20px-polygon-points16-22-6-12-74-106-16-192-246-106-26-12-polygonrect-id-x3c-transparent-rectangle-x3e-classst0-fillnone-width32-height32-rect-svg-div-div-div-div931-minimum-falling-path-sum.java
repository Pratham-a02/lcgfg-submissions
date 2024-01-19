class Solution{
    public int minFallingPathSum(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int res = (int)1e9;
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i = 0;i<n;i++){
            res = Math.min(res,solve(0,i,m,n,matrix,hm));
        }
        return res;
    }
    
    public int solve(int currRow,int currCol,int m,int n,int[][] matrix,HashMap<String,Integer> hm){
        if(currRow<0 || currCol<0 || currRow>=m || currCol>=n){
            return (int)1e9;
        }
        if(currRow == m-1){
            return matrix[currRow][currCol];
        }
        
        String currKey = currRow + "#" + currCol;
        if(hm.containsKey(currKey)){
            return hm.get(currKey);
        }
        
        int left = solve(currRow+1,currCol-1,m,n,matrix,hm);
        int down = solve(currRow+1,currCol,m,n,matrix,hm);
        int right = solve(currRow+1,currCol+1,m,n,matrix,hm);
        
        hm.put(currKey,matrix[currRow][currCol] + Math.min(left,Math.min(down,right)));
        return matrix[currRow][currCol] + Math.min(left,Math.min(down,right));
    }
}