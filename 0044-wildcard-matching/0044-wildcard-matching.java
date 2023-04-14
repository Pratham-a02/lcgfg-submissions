class Solution {
    public boolean isMatch(String s, String p){
        p = removeStars(p);
        int[][] dp = new int[s.length()+1][p.length()+1];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        return isPossible(s.length(),p.length(),s,p,dp) == 1;
    }
    
    public String removeStars(String s){
        if(s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int idx = 1;
        while(idx<s.length()){
        while(idx<s.length() && sb.charAt(sb.length()-1) == '*' && s.charAt(idx) == '*')idx++;
        if(idx<s.length()) sb.append(s.charAt(idx));
            idx++;
        }
        return sb.toString();
    }
    
    public int isPossible(int n,int m,String s,String p,int[][] dp){
        if(n == 0 || m == 0){
            if(n == 0 && m == 0){
                return dp[n][m] = 1;
            }    
            else if(m == 1 && p.charAt(m-1) == '*'){
                return dp[n][m] = 1;
            }
            else{
                return dp[n][m] = 0;
            }
        }
        
        if(dp[n][m] != -1){
            return dp[n][m];
        } 
        
        char ch1 = s.charAt(n-1);
        char ch2 = p.charAt(m-1);
        
        if(ch1 == ch2 || ch2 == '?'){
            return dp[n][m] = isPossible(n-1,m-1,s,p,dp);
        }
        else if(ch2 == '*'){
            boolean res = false;
            
            res = res || (isPossible(n-1,m,s,p,dp) == 1);
            res = res || (isPossible(n,m-1,s,p,dp) == 1);
            
            return dp[n][m] = (res?1:0);
        }
        else{
            return dp[n][m] = 0;
        }
    }
}