class Solution{
    public int mincostTickets(int[] days, int[] costs){
        int n = days.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return minCost(0,days,costs,n,dp);
    }
    
    public int minCost(int i,int[] days,int[] costs,int n,int[] dp){
        if(i>=n){
            return dp[i] = 0;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }
        
        int one_day = costs[0] + minCost(i+1,days,costs,n,dp);
        int max_day = days[i] + 7;
        int j = i;
        while(j<n && days[j]<max_day){
            j++;
        }
        
        int seven_day = costs[1] + minCost(j,days,costs,n,dp);
        max_day = days[i] + 30;
        j = i;
        while(j<n && days[j]<max_day){
            j++;
        }
        
        int fifteen_day = costs[2] + minCost(j,days,costs,n,dp);
        
        return dp[i] = Math.min(one_day,Math.min(seven_day,fifteen_day));
    }
}