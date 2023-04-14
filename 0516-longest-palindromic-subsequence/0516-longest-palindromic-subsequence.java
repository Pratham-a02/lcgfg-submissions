class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        // for(int[] arr:dp){
        //     Arrays.fill(arr,-1);
        // }
        
        return lps(s,0,s.length()-1,dp);
    }
    
//     public int lps(String s,int i,int j,int[][] dp){
//         if(i>j){
//             return 0;
//         }
//         if(i == j){
//             return 1;
//         }
        
//         if(dp[i][j] != -1){
//             return dp[i][j];
//         }
        
//         if(s.charAt(i) == s.charAt(j)){
//             return dp[i][j] = lps(s,i+1,j-1,dp) + 2;
//         }
//         else{
//             return dp[i][j] = Math.max(lps(s,i+1,j,dp),lps(s,i,j-1,dp));
//         }
//     }
    
    public int lps(String s,int I,int J,int[][] dp){
        int n = s.length();
        for(int gap = 0;gap<n;gap++){
            for(int i = 0,j = gap;j<n;i++,j++){
                if(i>=j){
                    dp[i][j] = (i==j)?1:0;
                    continue;
                }

                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[I][J];
    }
}