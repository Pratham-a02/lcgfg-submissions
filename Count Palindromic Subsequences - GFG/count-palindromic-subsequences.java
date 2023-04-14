//{ Driver Code Starts
import java.util.*;
class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			Solution ob  = new Solution();
			System.out.println(ob.countPS(str));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete below method */

class Solution
{
    int mod = (int)1e9 + 7;
    long countPS(String str){
        int n = str.length();
        long[][] dp = new long[n][n];
        for(long[] d:dp)
            Arrays.fill(d,-1);
        return count(0,n-1,str,dp);
    }
    long count(int i,int j,String str,long[][] dp){
        if(i>=j){
            return dp[i][j] = (i == j)?1:0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        long a = count(i+1,j,str,dp);
        long b = count(i,j-1,str,dp);
        long c = count(i+1,j-1,str,dp);
        
        return dp[i][j] = (str.charAt(i) != str.charAt(j))? (a+b-c + mod)%mod:(a+b+1 + mod)%mod;
    }
}