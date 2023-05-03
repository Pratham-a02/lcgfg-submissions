class Solution{
    public int minimumDeleteSum(String s1, String s2){
        int[][] dp = new int[1001][1001];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return minSum(0,0,s1,s2,dp);
    }
    
    public int minSum(int i,int j,String s1,String s2,int[][] dp){
        if(i == s1.length() && j == s2.length()){
            return 0;
        }
        else if(i<s1.length() && j == s2.length()){
            int curr = 0;
            for(int idx = i;idx<s1.length();idx++){
                curr += s1.charAt(idx);
            }
            return curr;
        }
        else if(j<s2.length() && i == s1.length()){
            int curr = 0;
            for(int idx = j;idx<s2.length();idx++){
                curr += s2.charAt(idx);
            }
            return curr;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = minSum(i+1,j+1,s1,s2,dp);
        }
        else{
            int first = (int)(s1.charAt(i)) + minSum(i+1,j,s1,s2,dp);
            int second = (int)(s2.charAt(j)) + minSum(i,j+1,s1,s2,dp);
            
            return dp[i][j] = Math.min(first,second);
        }
    }
}