class Solution{
    public int minExtraChar(String s, String[] dictionary){
        int[] dp = new int[51];
        Arrays.fill(dp,-1);
        HashSet<String> hs = new HashSet<>();
        for(String str:dictionary){
            hs.add(str);
        }
        return solve(0,s,hs,dp);
    }
    
    public int solve(int i,String s,HashSet<String> hs,int[] dp){
        if(i>=s.length()){
            return 0;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }
        
        int result = 1 + solve(i+1,s,hs,dp);
        
        for(int j = i;j<s.length();j++){
            String str = s.substring(i,j+1);
            if(hs.contains(str)){
                result = Math.min(result,solve(j+1,s,hs,dp));
            }
        }
        
        return dp[i] = result;
    }
}