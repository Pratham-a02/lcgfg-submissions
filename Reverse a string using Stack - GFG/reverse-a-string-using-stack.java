//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Solution obj = new Solution();
            System.out.println(obj.reverse(sc.next()));
        }
	}
}

// } Driver Code Ends
class Solution {
    public String reverse(String s){
        String ans = "";
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            st.push(s.charAt(i));
        }
        while(st.size()>0){
            char ch = st.pop();
            ans += ch;
        }
        return ans;
    }
}