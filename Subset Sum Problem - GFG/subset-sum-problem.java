// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{


    static boolean isSubsetSum(int N, int arr[], int sum){
        int[][] dp = new int[N+1][sum+1];
        for(int  []d:dp)
        {
            Arrays.fill(d,-1);
        }
        
        int w= isPossible(arr,sum,N,dp);
        
        if(w==1)
        {
            return true;
        }
        return false;
    }
    static int isPossible(int[] arr,int sum,int N,int[][] dp){
        if(sum<0)
        {
            return 0;
        }
        if(sum == 0){
            return dp[N][sum]= 1;
        }
        if(N == 0){
            return  dp[N][sum] = 0;
        }
        if(dp[N][sum]!= -1){
            return dp[N][sum];
        }
        int taken = 0;
        if(arr[N-1]<=sum){
          taken = isPossible(arr,sum- arr[N-1],N-1,dp);
        }
        int notTaken = isPossible(arr,sum,N-1,dp);
        if(taken ==1 || notTaken ==1)
        {
        return  dp[N][sum]=1;  
        }
        
        return dp[N][sum] = 0;
    }
    
}