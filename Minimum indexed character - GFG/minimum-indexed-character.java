//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to find the minimum indexed character.
    public static int minIndexChar(String str, String patt){
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            
            if(!hm.containsKey(ch)){
                hm.put(ch,i);
            }
        }
        
        int min = 100000;
        for(char ch:patt.toCharArray()){
            if(hm.containsKey(ch)){
                min = Math.min(min,hm.get(ch));
            }
        }
        if(min == 100000){
            return -1;
        }
        else{
            return min;
        }
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
		    t--;
		    
		    String s1=sc.next();
		    String s2=sc.next();
		    
		    int res = new Solution().minIndexChar(s1, s2);
		    System.out.println(res);
		}
	}
}

// } Driver Code Ends