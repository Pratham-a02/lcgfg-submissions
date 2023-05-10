//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends

class Sol{
    public int countRev(String s){
        if(s.length()%2 != 0){
            return -1;
        }
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch == '{'){
                st.push(ch);
            }
            else{
                if(st.isEmpty() || st.peek() != '{'){
                    st.push(ch);
                }
                else{
                    st.pop();
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(st.size()>0){
            sb.insert(0,st.pop());
        }
        
        int a = 0;
        int b = 0;
        
        for(int i = 0;i<sb.length();i++){
            if(sb.charAt(i) == '{'){
                a++;
            }
            else{
                b++;
            }
        }
        
        return (a+1)/2 + (b+1)/2;
    }
}