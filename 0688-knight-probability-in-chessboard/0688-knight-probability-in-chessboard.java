class Solution{
    int dx[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    int dy[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
    
    public double knightProbability_R(int n, int k, int row, int column,double[][][] dp){
        if(k == 0){
            return dp[k][row][column] = 1.0;
        }
        
        if(dp[k][row][column] != 0){
            return dp[k][row][column];
        }
        
        double count = 0;
        
        for(int d = 0;d<8;d++){
            int r = row + dx[d];
            int c = column + dy[d];
            
            if(r>=0 && c>=0 && r<n && c<n){
                count += knightProbability_R(n,k-1,r,c,dp);
            }
        }
        return dp[k][row][column] = (count/8.0);
    }
    
    public double knightProbability(int n, int k, int row, int column){
        double[][][] dp = new double[101][26][26];
        // Arrays.fill(dp,-1.0);
        return knightProbability_R(n,k,row,column,dp);
}
}