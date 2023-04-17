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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends
class Solution{
	public int maxSumIS(int arr[], int n){ 
	    if(n == 1){
	        return arr[0];
	    }
	    int[] dp = new int[n];
        return maxSumIS_Tab(arr,n,dp);  
	}  
	
	public int maxSumIS_Tab(int[] arr,int n,int[] dp){
	    int sum = 0;
	    for(int i = 0;i<n;i++){
	        dp[i] = arr[i];
	        for(int j = i-1;j>=0;j--){
	            if(arr[j]<arr[i]){
	                dp[i] = Math.max(dp[i],dp[j]+arr[i]);
	            }
	        }
	        sum = Math.max(sum,dp[i]);
	    }
	    return sum;
	}
}