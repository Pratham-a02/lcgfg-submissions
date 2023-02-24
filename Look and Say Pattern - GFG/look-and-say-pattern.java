//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            

            Solution ob = new Solution();
            
            System.out.println(ob.lookandsay(n));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String lookandsay(int n) {
        if(n == 1){
            return "1";
        }
        if(n == 2){
            return "11";
        }
        
        String res = lookandsay(n-1);
        String curr = "";
        int count = 1;
        for(int i = 1;i<res.length();i++){
            if(res.charAt(i) != res.charAt(i-1)){
                curr += count;
                curr += res.charAt(i-1);
                count = 1;
            }
            else{
                count++;
            }
            
            if(i == res.length()-1){
                curr += count;
                curr += res.charAt(i);
            }
        }
        return curr;
    }
}
