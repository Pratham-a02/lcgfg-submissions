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
        return mcm(0,N-1,arr,dp);
    }
    
    public static int mcm(int si,int ei,int[] arr,int[][] dp){
        if(ei-si == 1 || ei == si){
            return dp[si][ei] = 0;
        }
        
        if(dp[si][ei] != -1){
            return dp[si][ei];
        }
        
        int minCost = (int)1e9;
        for(int cut = si+1;cut<ei;cut++){
            int leftSide = mcm(si,cut,arr,dp);
            int rightSide = mcm(cut,ei,arr,dp);
            
            minCost = Math.min(minCost,leftSide + arr[si] * arr[cut] * arr[ei] + rightSide);
        }
        
        return dp[si][ei] = minCost;
    }
}