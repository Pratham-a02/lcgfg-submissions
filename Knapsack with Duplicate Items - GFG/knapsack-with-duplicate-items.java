//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends

class Solution{
    public static int knapSack(int N,int W,int[] val,int[] wt){
        int[][] dp = new int[N+1][W+1];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        return solve(0,W,val,wt,N,dp);
    }
    
    public static int solve(int idx,int W,int[] val,int[] wt,int n,int[][] dp){
        if(idx>=n){
            return 0;
        }
        
        if(dp[idx][W] != -1){
            return dp[idx][W];
        }
        
        int taken = 0;
        
        if(W-wt[idx]>=0){
            taken = val[idx] + solve(idx,W-wt[idx],val,wt,n,dp);
        }
        int noTaken = solve(idx+1,W,val,wt,n,dp);
        
        return dp[idx][W] = Math.max(taken,noTaken);
    }
}