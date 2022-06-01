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
   static boolean isSubsetSumHelper(int N, int arr[], int sum, Boolean[][]dp){
       //if(sum<0)return 0;
       if(N==0 || sum==0)
         {
             return dp[N][sum]=sum==0?true:false;
         }

    // IDHR SE
      if(dp[N][sum]!=null){
          return dp[N][sum];
      }
   // IDHR tk
       boolean isSubsetSum = false;
       if(sum-arr[N-1]>=0){
       isSubsetSum =isSubsetSum || isSubsetSumHelper(N-1,arr,sum-arr[N-1],dp) ;
       }
       isSubsetSum = isSubsetSum ||  isSubsetSumHelper(N-1,arr,sum,dp);
       return dp[N][sum]=isSubsetSum ;
   }

    static Boolean isSubsetSum(int N, int arr[], int sum){
        Boolean dp[][] = new Boolean[N+1][sum+1];
        return isSubsetSumHelper(N,arr,sum, dp);
    
    }
}