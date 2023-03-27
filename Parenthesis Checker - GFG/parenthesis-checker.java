//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends
class Solution{
    static boolean ispar(String x){
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<x.length();i++){
            if(x.charAt(i) == '(' || x.charAt(i) == '{' || x.charAt(i) == '['){
                st.push(x.charAt(i));
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                
                char ch = st.pop();
                if(x.charAt(i) == ')' && ch != '('){
                    return false;
                }
                else if(x.charAt(i) == '}' && ch != '{'){
                    return false;
                }
                else if(x.charAt(i) == ']' && ch != '['){
                    return false;
                }
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}
