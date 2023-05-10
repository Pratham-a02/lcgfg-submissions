class Solution{
    public int minFlipsMonoIncr(String s){
        int n = s.length();
        int[][] dp = new int[n+1][2];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        return minFlips(0,0,s,dp);
    }
    
    public int minFlips(int currIdx,int prev,String s,int[][] dp){
        if(currIdx>=s.length()){
            return 0;
        }
        
        if(dp[currIdx][prev] != -1){
            return dp[currIdx][prev];
        }
        
        int flip = Integer.MAX_VALUE;
        int no_flip = Integer.MAX_VALUE;
        
        if(s.charAt(currIdx) == '0'){
            if(prev == 0){
                flip = 1+minFlips(currIdx+1,1,s,dp);
                no_flip = minFlips(currIdx+1,0,s,dp);
            }
            else{
                flip = 1+minFlips(currIdx+1,1,s,dp);
            }
        }
        else{
            if(prev == 0){
                flip = 1+minFlips(currIdx+1,0,s,dp);
                no_flip = minFlips(currIdx+1,1,s,dp);
            }
            else{
                no_flip = minFlips(currIdx+1,1,s,dp);
            }
        }
        
        return dp[currIdx][prev] = Math.min(flip,no_flip);
    }
}