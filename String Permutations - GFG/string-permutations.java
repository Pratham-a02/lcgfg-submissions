//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends

class Solution{
    public ArrayList<String> permutation(String S){
        ArrayList<String> ans = new ArrayList<>();
        solve(S,"",ans);
        Collections.sort(ans);
        return ans;
    }
	   
	public void solve(String s,String asf,ArrayList<String> ans){
	    if(s.length() == 0){
	        ans.add(asf);
	    }
	    
	    for(int i = 0;i<s.length();i++){
	        char ch = s.charAt(i);
	        String ros = s.substring(0,i) + s.substring(i+1);
	        solve(ros,asf+ch,ans);
	    }
	}
}
