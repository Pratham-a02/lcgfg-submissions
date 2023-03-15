class Solution {
    public int numDecodings(String s){
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return totalWays(0,s,dp);
    }
    
    public int totalWays(int idx,String s,int[] dp){
        if(idx == s.length()){
            return dp[idx] = 1;
        }
        
        char ch1 = s.charAt(idx);
        if(ch1 == '0'){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int count = 0;
        count += totalWays(idx+1,s,dp);
        
        if(idx<s.length()-1){
            char ch2 = s.charAt(idx+1);
            int num = (ch1-'0')*10 + (ch2 - '0');
            if(num<=26){
                count+= totalWays(idx+2,s,dp);
            }
        }
        return dp[idx] = count;
    }
}