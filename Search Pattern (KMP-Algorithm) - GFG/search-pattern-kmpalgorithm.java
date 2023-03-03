//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static ArrayList<Integer> search(String pat, String txt){
        int[] lps = getLPS(pat);
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while(i<txt.length()){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                
                if(j == pat.length()){
                    ans.add(i-j+1);
                    j = lps[j-1];
                }
            }
            else if(j == 0){
                i++;
            }
            else{
                j = lps[j-1];
            }
        }
        return ans;
    }
    
    public static int[] getLPS(String pat){
        int len = 0;
        int i = 1;
        int[] lps = new int[pat.length()];
        // lps[0] = 0;
        while(i<pat.length()){
            if(pat.charAt(i) == pat.charAt(len)){
                lps[i] = len+1;
                len++;
                i++;
            }
            else if(len == 0){
                lps[i] = 0;
                len = 0;
                i++;
            }
            else{
                len = lps[len-1];
            }
        }
        // for(int val:lps){
        //     System.out.print(val+" ");
        // }
        return lps;
    }
}