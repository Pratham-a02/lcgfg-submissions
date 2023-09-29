//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends




class Solution{

	public int perfectSum(int arr[],int n, int sum){ 
	    int[][] dp = new int[n+1][sum+1];
	    for(int[] d:dp)
	        Arrays.fill(d,-1);
	    return solve(0,sum,arr,n,dp)%1000000007;
	} 
	public int solve(int currIdx,int sum,int[] arr,int n,int[][] dp){
	    if(sum == 0 && currIdx == n)
	        return 1;
	    if(sum <0)
	        return 0;
	    if(currIdx>=n && sum!=0)
	        return 0;
	    
	    if(dp[currIdx][sum]!= -1)
	        return dp[currIdx][sum];
	        
	    
	    int count = 0;
	    
	    count = (count%1000000007 + solve(currIdx+1,sum-arr[currIdx],arr,n,dp)%1000000007 + solve(currIdx+1,sum,arr,n,dp)%1000000007)%1000000007;
	    
	    return dp[currIdx][sum] = count%1000000007;
	}
}