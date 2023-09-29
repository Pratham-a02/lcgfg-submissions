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
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends

class Solution{
    static int maxLength(String s){
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                st.push(i);
            }
            else{
                if(st.size()>0 && s.charAt(st.peek()) == '('){
                    st.pop();
                }
                else{
                    st.push(i);
                }
            }
        }
        
        int currLen = s.length();
        int max = 0;
        while(st.size()>0){
            int ele = st.pop();
            max = Math.max(max,currLen - ele - 1);
            currLen = ele;
        }
        
        return Math.max(max,currLen);
    }
}