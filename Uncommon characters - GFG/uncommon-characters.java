//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String A = sc.next();
                    String B = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.UncommonChars(A, B));
                }
        }
}
// } Driver Code Ends

class Solution{
    String UncommonChars(String A,String B){
        HashSet<Character> hs = new HashSet<>();
        for(char c : A.toCharArray()){
            hs.add(c);
        }
        
        TreeSet<Character> ts = new TreeSet<>();
        for(char c : B.toCharArray()){
            if(!hs.contains(c)){
                ts.add(c);
            }
        }
        hs.clear();
        for(char c : B.toCharArray()){
            hs.add(c);
        }
        
        for(char c : A.toCharArray()){
            if(!hs.contains(c)){
                ts.add(c);
            }
        }
        
        String ans = "";
        for(char ele : ts){
            ans += ele;
        }
        
        if(ans == "") return "-1";
        return ans;
    }
}