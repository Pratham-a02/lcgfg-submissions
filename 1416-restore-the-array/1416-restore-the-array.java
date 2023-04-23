class Solution {
    int mod = 1000000007;
    public boolean isValid(String str,int k){
        if(str.charAt(0) == '0'){
            return false;
        }
        if(Long.parseLong(str)>k){
            return false;
        }
        return true;
    }
    
    public int numberOfArrays(String s, int k){
        String mx = Integer.toString(k);
        int mxSize = mx.length();
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return totalWays(0,s,k,mxSize,dp);
    }
    
    public int totalWays(int idx,String s,int k,int mxSize,int[] dp){
        if(idx>=s.length()){
            return dp[idx] = 1;
        }
        
        if(dp[idx] != -1){
            return dp[idx];
        }
        
        int count = 0;
        
        for(int j = idx;j<s.length();j++){
            String str = s.substring(idx,j+1);
            if(j-idx+1 > mxSize){
                break;
            }
            else if(isValid(str,k)){
                count += totalWays(j+1,s,k,mxSize,dp)%mod;
                count = count%mod;
            }
        }
        
        return dp[idx] = count%mod;
    }
}