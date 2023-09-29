//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int t = Integer.parseInt(sc.next());
		
		while(t>0)
		{
		    String s = sc.next();
		    
		    Solution T = new Solution();
		    System.out.println(T.fun(s));
		    
		    t--;
		}
	}
}

// } Driver Code Ends

class Solution{
    public int fun(String s){
        int ap = 0;
        int apbp = 0;
        int apbpcp = 0;
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch == 'a'){
                ap = ((2*ap)%1000000007 + 1)%1000000007;
            }
            else if(ch == 'b'){
                apbp = ((2*apbp)%1000000007 + ap%1000000007)%1000000007;
            }
            else{
                apbpcp = ((2*apbpcp)%1000000007 + apbp%1000000007)%1000000007;
            }
        }
        return apbpcp%1000000007;
    }
}