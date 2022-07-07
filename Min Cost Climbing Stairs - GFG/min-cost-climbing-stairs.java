// { Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] cost = new int[N];
            
            for(int i=0 ; i<N ; i++)
                cost[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.minCostClimbingStairs(cost,N));
        }
    }
}// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    static int minCostClimbingStairs(int[] cost , int N) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp,-1);
        int a = minCost(cost,0,dp);
        int b = minCost(cost,1,dp);
        return Math.min(a,b);
    }
    static int minCost(int[] cost,int currIdx,int[] dp){
        if(currIdx == cost.length){
            return 0;
        }
        if(currIdx > cost.length){
            return (int)1e9;
        }
        if(dp[currIdx]!= -1){
            return dp[currIdx];
        }
        int oneStep = cost[currIdx] + minCost(cost,currIdx+1,dp);
        int twoStep = cost[currIdx] + minCost(cost,currIdx+2,dp);
        
        dp[currIdx] = Math.min(oneStep,twoStep);
        return dp[currIdx];
    }
}