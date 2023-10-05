//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine().trim());
        while (tc-- > 0) {
            String S1 = in.readLine();
            String S2 = in.readLine();
            Solution ob = new Solution();
            System.out.println( ob.countWays(S1,S2) );
        }
    }
}
// } Driver Code Ends

class Solution{
    int countWays(String S1,String S2){ 
        int[][] dp = new int[S1.length()+1][S2.length()+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return solve(S1.length(),S2.length(),S1,S2,dp);
    }
    
    public int solve(int m,int n,String s1,String s2,int[][] dp){
        if(m == 0 && n!= 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        
        int count = 0;
        
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            count += solve(m-1,n-1,s1,s2,dp) + solve(m-1,n,s1,s2,dp);
        }
        else{
            count += solve(m-1,n,s1,s2,dp);
        }
        return dp[m][n] = count;
    }
}