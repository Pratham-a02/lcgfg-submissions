//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends
class Pair{
    int totalTrue;
    int totalFalse;
    
    Pair(){}
    Pair(int totalTrue,int totalFalse){
        this.totalTrue = totalTrue;
        this.totalFalse = totalFalse;
    }
}

class Solution{
    public static int countWays(int N, String S){
        Pair[][] dp = new Pair[N][N];
        Pair ans = countWays_R(0,N-1,S,dp);
        return ans.totalTrue;
    }
    
    public static void evaluate(Pair left,Pair right,Pair res,char opr){
        int mod = 1003;
        int total = ((left.totalTrue + left.totalFalse) * (right.totalTrue + right.totalFalse))%mod;
        int ttrue = 0;
        int tfalse = 0;
        
        if(opr == '|'){
            tfalse = (left.totalFalse * right.totalFalse)%mod;
            ttrue = (total - tfalse + mod)%mod;
        }
        else if(opr == '^'){
            ttrue = (left.totalTrue * right.totalFalse)%mod + (left.totalFalse*right.totalTrue)%mod;
            tfalse = (total - ttrue + mod)%mod;
        }
        else if(opr == '&'){
            ttrue = (left.totalTrue * right.totalTrue)%mod;
            tfalse = (total - ttrue + mod)%mod;
        }
        
        res.totalTrue = (res.totalTrue + ttrue)%mod;
        res.totalFalse = (res.totalFalse + tfalse)%mod;
        
    }
    
    public static Pair countWays_R(int si,int ei,String s,Pair[][] dp){
        if(si == ei){
            char ch = s.charAt(si);
            int t = (ch == 'T')?1:0;
            int f = (ch == 'F')?1:0;
            
            return dp[si][ei] = new Pair(t,f);
        }
        if(dp[si][ei] != null){
            return dp[si][ei];
        }
        
        Pair res = new Pair();
        
        for(int cut = si+1;cut<ei;cut+=2){
            Pair left = countWays_R(si,cut-1,s,dp);
            Pair right = countWays_R(cut+1,ei,s,dp);
            
            evaluate(left,right,res,s.charAt(cut));
        }
        return dp[si][ei] = res;
    }
}