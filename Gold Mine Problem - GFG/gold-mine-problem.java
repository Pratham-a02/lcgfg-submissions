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
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int M[][]){
        int st = -1;
        int end = -1;
        int[][] dp = new int[n+1][m+1];
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<M.length;i++){
            for(int j = 0;j<M[0].length;j++){
                int curr = max(i,j,M,dp);
                max = Math.max(max,curr);
            }
        }
        
        
        return max;
    }
    
    public static int max(int currRow,int currCol,int[][] mat,int[][] dp) {
        if(currRow == mat.length-1 && currCol == mat[0].length-1){
            return dp[currRow][currCol] = mat[currRow][currCol];
        }
        
        if(currRow<0 || currRow>=mat.length || currCol>=mat[0].length){
            return 0;
        }
        
        if(dp[currRow][currCol] != 0){
            return dp[currRow][currCol];
        }
        
        int up = mat[currRow][currCol] + max(currRow - 1,currCol+1,mat,dp);
        int right = mat[currRow][currCol] + max(currRow,currCol+1,mat,dp);
        int down = mat[currRow][currCol] + max(currRow + 1,currCol+1,mat,dp);
        
        return dp[currRow][currCol] = Math.max(up,Math.max(right,down));
    }
}