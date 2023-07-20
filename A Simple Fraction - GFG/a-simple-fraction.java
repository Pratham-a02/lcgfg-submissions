//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int numerator = Integer.parseInt(S[0]);
            int denominator = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            String ans = ob.fractionToDecimal(numerator, denominator);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution{
    public String fractionToDecimal(int num,int den){
       StringBuilder ans = new StringBuilder();
       
       int q = num/den;
       int r = num%den;
       ans.append(q);
       if(r == 0){
           return ans.toString();
       }
       else{
           ans.append(".");
           HashMap<Integer,Integer> hm = new HashMap<>();
           while(r != 0){
               if(hm.containsKey(r)){
                   int len = hm.get(r);
                   ans.insert(len,"(");
                   ans.append(")");
                   break;
               }
               else{
                   hm.put(r,ans.length());
                   r *= 10;
                   q = r/den;
                   r = r%den;
                   ans.append(q);
               }
           }
       }
       return ans.toString();
    }
}