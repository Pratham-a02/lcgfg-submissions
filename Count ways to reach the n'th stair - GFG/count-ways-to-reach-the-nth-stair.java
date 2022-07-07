// { Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}// } Driver Code Ends


class Solution
{
    //Function to count number of ways to reach the nth stair.
    static int countWays(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return totalWays(0,n,dp);
    }
    static int totalWays(int currIdx,int target,int[] dp){
        if(currIdx == target){
            return 1;
        }
        if(currIdx > target){
            return 0;
        }
        if(dp[currIdx]!= -1){
            return dp[currIdx];
        }
        int oneStep = totalWays(currIdx + 1,target,dp);
        int twoStep = totalWays(currIdx + 2,target,dp);
        
        dp[currIdx] = (oneStep + twoStep)%1000000007;
        return dp[currIdx];
    }
}

