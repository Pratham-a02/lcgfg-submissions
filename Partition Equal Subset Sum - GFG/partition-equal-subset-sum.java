//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends

class Solution{
    static int equalPartition(int N,int[] arr){
        int sum = 0;
        for(int val : arr){
            sum += val;
        }
        if(sum%2 != 0){
            return 0;
        }
        int[][] dp = new int[N+1][sum+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        int ans = solve(0,sum/2,arr,dp);
        if(ans == 1){
            return 1;
        }
        else{
            return 0;
        }
    }
    
    public static int solve(int idx,int sum,int[] arr,int[][] dp){
        if(idx == arr.length){
            return 0;
        }
        
        if(sum == 0){
            return 1;
        }
        
        if(dp[idx][sum] != -1){
            return dp[idx][sum];
        }
        
        int taken = 0;
        if(arr[idx]<=sum){
            taken = solve(idx+1,sum-arr[idx],arr,dp);
        }
        int noTaken = solve(idx+1,sum,arr,dp);
        
        if(taken == 1 || noTaken == 1){
            return dp[idx][sum] = 1;
        }
        else{
            return dp[idx][sum] = 0;
        }
    }
}