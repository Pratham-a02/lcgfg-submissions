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
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.maxSubstring(s));
        }
    }
}
// } Driver Code Ends

class Solution{
    int maxSubstring(String S){
        int currSum = 0;
        int max = 0;
        
        for(int i = 0;i<S.length();i++){
            if(S.charAt(i) == '0'){
                currSum++;
            }
            else if(S.charAt(i) == '1'){
                currSum--;
            }
            
            if(currSum<0){
                currSum = 0;
            }
            max = Math.max(max,currSum);
        }
        return max == 0?-1:max;
    }
}