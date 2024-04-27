class Solution{
    public String longestPalindrome(String s){
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for(int gap = 0;gap<n;gap++){
            for(int i = 0,j = gap;j<n;i++,j++){
                if(gap == 0){
                    dp[i][j] = 1;  
                } 
                else if(gap == 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j))?2:0;
                }
                else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1] != 0)?(dp[i+1][j-1]+2):0;
                }
            }
        }
        int maxLen = 1;
        int start = 0;
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(dp[i][j]>maxLen){
                    maxLen = dp[i][j];
                    start = i;
                }
            }
        }
        
        return s.substring(start,start+maxLen);
    }
}