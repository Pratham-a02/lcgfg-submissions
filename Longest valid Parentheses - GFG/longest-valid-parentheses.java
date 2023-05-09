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
    static int maxLength(String S){
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<S.length();i++){
            char ch = S.charAt(i);
            
            if(ch == '('){
                st.push(i);
            }
            else if(ch == ')'){
                if(st.isEmpty() || S.charAt(st.peek()) != '('){
                    st.push(i);
                }
                else{
                    st.pop();
                }
            }
        }
        
        int maxLen = S.length();
        int max = 0;
        while(st.size()>0){
            int currLen = st.pop();    
            maxLen = maxLen - currLen - 1;
            max = Math.max(max,maxLen);
            maxLen = currLen;
        }
        return Math.max(max,maxLen);
    }
}