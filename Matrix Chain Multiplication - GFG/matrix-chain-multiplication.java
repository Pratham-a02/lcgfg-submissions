//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends

class Solution{
    public static int matrixMultiplication(int N, int[] arr){
        int[][] dp = new int[N][N];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        // mcm(0,N-1,arr,dp);
        return mcm_Tab(0,N-1,arr,dp);
    }
    
    public static int mcm_M(int si,int ei,int[] arr,int[][] dp){
        if(ei-si == 1 || ei == si){
            return dp[si][ei] = 0;
        }
        
        if(dp[si][ei] != -1){
            return dp[si][ei];
        }
        
        int minCost = (int)1e9;
        for(int cut = si+1;cut<ei;cut++){
            int leftSide = mcm_M(si,cut,arr,dp);
            int rightSide = mcm_M(cut,ei,arr,dp);
            
            minCost = Math.min(minCost,leftSide + arr[si] * arr[cut] * arr[ei] + rightSide);
        }
        
        return dp[si][ei] = minCost;
    }
    
    
    public static int mcm_Tab(int SI,int EI,int[] arr,int[][] dp){
        int n = arr.length;
        
        for(int gap = 1;gap<n;gap++){
            for(int si = 0,ei = gap;ei<n;si++,ei++){
                if(si == ei || ei - si == 1){
                    dp[si][ei] = 0;
                    continue;
                }
                
                int minCost = (int)1e9;
                for(int cut = si+1;cut<ei;cut++){
                    int left = dp[si][cut];
                    int right = dp[cut][ei];
                    
                    minCost = Math.min(minCost,left + arr[si]*arr[cut]*arr[ei] + right);
                    dp[si][ei] = minCost;
                }
            }
        }
        return dp[SI][EI];
    }
}