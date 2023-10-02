//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(input_line[0]);
            int n2 = Integer.parseInt(input_line[1]);
            int n3 = Integer.parseInt(input_line[2]);
            input_line = read.readLine().trim().split("\\s+");
            String A = input_line[0];
            String B = input_line[1];
            String C = input_line[2];
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(A, B, C, n1, n2, n3));
        }
    } 
} 
// } Driver Code Ends

class Solution{ 
    public static int LCSof3(String A,String B,String C,int n1,int n2,int n3){ 
        int[][][] dp = new int[n1+1][n2+1][n3+1];
        for(int[][] d:dp){
            for(int[]d1:d){
                Arrays.fill(d1,-1);
            }
        }
        return solve(n1,n2,n3,A,B,C,dp);
    }
    
    public static int solve(int n,int m,int k,String a,String b,String c,int[][][] dp){
        if(n == 0 && m == 0 && k == 0) return dp[n][m][k] = 0;
        
        if(n == 0 || m == 0 || k == 0) return dp[n][m][k] = 0;
        
        if(dp[n][m][k] != -1){
            return dp[n][m][k];
        }
        
        if(a.charAt(n-1) == b.charAt(m-1) && b.charAt(m-1) == c.charAt(k-1)){
            return dp[n][m][k] = 1 + solve(n-1,m-1,k-1,a,b,c,dp);
        }
        else{
            return dp[n][m][k] = Math.max(solve(n-1,m,k,a,b,c,dp),Math.max(solve(n,m-1,k,a,b,c,dp),solve(n,m,k-1,a,b,c,dp)));
        }
    }
} 