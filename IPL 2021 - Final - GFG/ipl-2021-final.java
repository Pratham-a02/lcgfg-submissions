//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0;i<S.length();i++){
            char ch = S.charAt(i);
            
            if(ch == '('){
                st.push(i);
            }
            else{
                if(st.isEmpty() || S.charAt(st.peek()) != '('){
                    st.push(i);
                }
                else{
                    st.pop();
                }
            }
        }
        
        int max = 0;
        int maxLen = S.length();
        
        while(st.size()>0){
            int currLen = st.pop();
            max = Math.max(max,maxLen-currLen-1);
            maxLen = currLen;
        }
        
        return Math.max(max,maxLen);
    }
}