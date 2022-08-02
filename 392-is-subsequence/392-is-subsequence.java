class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] d:dp)
            Arrays.fill(d,-1);
        if(n == 0)
            return true;
        int ans = lcs(0,0,n,m,s,t,dp);
        if(s.length() == ans)
            return true;
        return false;
    }
    public int lcs(int curr1,int curr2,int n,int m,String text1,String text2,int[][] dp){
        if(curr1>=n || curr2>=m)
            return 0;
        
        if(dp[curr1][curr2] != -1){
            return dp[curr1][curr2];
        }
        
        if(text1.charAt(curr1) == text2.charAt(curr2)){
            return dp[curr1][curr2] = 1 + lcs(curr1+1,curr2+1,n,m,text1,text2,dp);
        }
        else{
            return dp[curr1][curr2] = Math.max(lcs(curr1+1,curr2,n,m,text1,text2,dp),lcs(curr1,curr2+1,n,m,text1,text2,dp));
        }
        
    }
}