//{ Driver Code Starts
//Initial Template for Java

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
            System.out.println(ob.countNumberswith4(N));
        }
    }
}
// } Driver Code Ends

class Solution{
    static int countNumberswith4(int N){
        boolean[] dp = new boolean[N+1];
        int count = 0;
        for(int i = 1;i<=N;i++){
            if(dp[i] == true){
                count++;
                continue;
            }
            if(contains4(i)){
                count++;
                dp[i] = true;
            }
        }
        return count;
    }
    
    static boolean contains4(int n){
        while(n>0){
            if(n%10 == 4){
                return true;
            }
            n = n/10;
        }
        return false;
    }
}