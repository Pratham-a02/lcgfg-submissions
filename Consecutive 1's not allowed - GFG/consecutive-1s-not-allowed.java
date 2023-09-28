//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {
    long countStrings(int n) {
        long[] dp = new long[n+1];
        
        dp[0] = 1;
        dp[1] = 2;
        
        for(int i = 2;i<dp.length;i++){
            dp[i] = (dp[i-1]%1000000007 + dp[i-2]%1000000007)%1000000007;
        }
        return dp[n]%1000000007;
    }
}