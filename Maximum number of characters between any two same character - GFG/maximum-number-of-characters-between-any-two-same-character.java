//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.maxChars(s));
                }
                
        }
}
// } Driver Code Ends

class Solution{
    public int maxChars(String s){
        int max = -1;
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(hm.containsKey(ch)){
                max = Math.max(max,i-hm.get(ch)-1);
            }
            else{
                hm.put(ch,i);
            }
        }
        return max;
    }
}