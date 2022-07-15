// { Driver Code Starts

import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        int[][] dp = new int[price.length+1][n+1];
        for(int[] d: dp){
            Arrays.fill(d,-1);
        }
        return maxProfit(0,price,n,dp);
    }
    public int maxProfit(int currIdx,int[] price,int n,int[][] dp){
        if(n==0){
            return 0;
        }
        if(currIdx>=price.length){
            return Integer.MIN_VALUE;
        }
        if(dp[currIdx][n]!= -1){
            return dp[currIdx][n];
        }
        int taken = 0;
        if(currIdx+1<=n){
            taken = price[currIdx] + maxProfit(currIdx,price,n-(currIdx+1),dp);
        }
        int notTaken = maxProfit(currIdx+1,price,n,dp);
        
        return dp[currIdx][n] = Math.max(taken,notTaken);
    }
}