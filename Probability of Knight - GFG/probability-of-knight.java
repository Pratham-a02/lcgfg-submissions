//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String []S = s.split(" ");
            int N = Integer.parseInt(S[0]);
            int start_x = Integer.parseInt(S[1]);
            int start_y = Integer.parseInt(S[2]);
            int step = Integer.parseInt(S[3]);
            Solution ob = new Solution();
            double ans = ob.findProb(N, start_x, start_y, step);
            System.out.println(String.format("%.6f", ans));           
        }
    }
}

// } Driver Code Ends

class Solution{
    int[][] dirs = {{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
    public double findProb(int N,int start_x,int start_y,int step){
        double[][][] dp = new double[101][101][101];
        return solve(start_x,start_y,step,N,dp);
    }
    
    public double solve(int cr,int cc,int k,int n,double[][][] dp){
        if(k == 0){
            return dp[k][cr][cc] = 1.0;
        }
        
        if(dp[k][cr][cc] != 0){
            return dp[k][cr][cc];
        }
        
        double count = 0;
        
        for(int[] dir:dirs){
            int dx = cr + dir[0];
            int dy = cc + dir[1];
            
            if(dx>=0 && dy>=0 && dx<n && dy<n){
                count += solve(dx,dy,k-1,n,dp);
            }
        }
        
        return dp[k][cr][cc] = (count/8.0);
    }
}