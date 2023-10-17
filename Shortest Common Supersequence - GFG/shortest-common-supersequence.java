//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends

class Solution{
    public static int shortestCommonSupersequence(String X,String Y,int m,int n){
        int[][] dp = new int[X.length()+1][Y.length()+1];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        int lcs = solve(m,n,X,Y,dp);
        return (X.length()-lcs) + (Y.length()-lcs) + lcs;
    }
    
    public static int solve(int m,int n,String X,String Y,int[][] dp){
        if(m == 0 && n == 0){
            return dp[m][n] = 0;
        }
        if(m == 0 || n == 0){
            return dp[m][n] = 0;
        }
        
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        
        if(X.charAt(m-1) == Y.charAt(n-1)){
            return dp[m][n] = 1 + solve(m-1,n-1,X,Y,dp);
        }
        else{
            return dp[m][n] = Math.max(solve(m-1,n,X,Y,dp),solve(m,n-1,X,Y,dp));
        }
    }
}