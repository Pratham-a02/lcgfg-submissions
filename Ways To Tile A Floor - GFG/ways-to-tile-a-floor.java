//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfWays(N));
        }
    }
}
// } Driver Code Ends

class Solution{
    static Long numberOfWays(int N){
        long[] dp = new long[N+1];
        dp[0] = dp[1] = 1;
        
        for(int i = 2;i<dp.length;i++){
            dp[i] = (dp[i-1]%1000000007 + dp[i-2]%1000000007)%1000000007;
        }
        return dp[N]%1000000007;
    }
}