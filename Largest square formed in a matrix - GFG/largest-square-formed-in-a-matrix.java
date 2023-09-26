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
            String a[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            String a1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[n][m];
            for(int i = 0;i < n*m;i++)
                mat[i/m][i%m] = Integer.parseInt(a1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends

class Solution{
    static int maxSquare(int m,int n,int mat[][]){
        int side = 0;
        int area = 0;
        int[][] dp = new int[51][51];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 1){
                    side = solve(i,j,m,n,mat,dp);
                    area = Math.max(area,side);
                }
            }
        }
        return area;
    }
    
    public static int solve(int cr,int cc,int m,int n,int[][] mat,int[][] dp){
        if(cr<0 || cc<0 || cr>=m || cc>= n || mat[cr][cc] == 0){
            return 0;
        }
        
        if(dp[cr][cc] != -1){
            return dp[cr][cc];
        }
        
        int right = 1 + solve(cr,cc+1,m,n,mat,dp);
        int diag = 1 + solve(cr+1,cc+1,m,n,mat,dp);
        int down = 1 + solve(cr+1,cc,m,n,mat,dp);
        
        return dp[cr][cc] = Math.min(right,Math.min(diag,down));
    }
}