class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        // int[][] dp = new int[n+30][target+30];
        // for(int[] d:dp)
        //     Arrays.fill(d,-1);
        int ans = totalWays(n,k,target,new HashMap<String,Integer>());
        return ans%1000000007;
    }
    
    public int totalWays(int n,int k,int target,HashMap<String,Integer>hm){
        
        if(n == 0 && target!=0)
            return 0;
        if(n == 0 && target<0)
            return 0;
        if(n>0 && target == 0)
            return 0;
        if(n == 0 && target == 0)
            return 1;
        // if(dp[n][target]!= -1)
        //     return dp[n][target];
        String currKey = n + "_" + target;
        if(hm.containsKey(currKey))
            return hm.get(currKey);
        
        int count = 0;
        
        for(int i = 1;i<=k;i++){
            count = (count%1000000007 + totalWays(n-1,k,target-i,hm)%1000000007)%1000000007;
        }
        hm.put(currKey,count);
        return count;
    }
}