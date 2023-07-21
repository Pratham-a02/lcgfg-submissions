//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++){
		    String s = in.next();
		    if (new Sol().isPossible (s) == 1)
		        System.out.println ("Yes");
		    else
		        System.out.println ("No");
		}
	}
}

// Contributed By: Pranay Bansal


// } Driver Code Ends

class Sol{
    public int isPossible(String S){
        int[] farr = new int[26];
        
        for(char ch : S.toCharArray()){
            farr[ch-'a']++;
        }
        
        int count = 0;
        
        for(int i = 0;i<farr.length;i++){
            if(farr[i]%2 != 0){
                count++;
            }
        }
        
        return count>1?0:1;
    }
}