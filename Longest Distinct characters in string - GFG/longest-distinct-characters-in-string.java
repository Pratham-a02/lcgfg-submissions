//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int longestSubstrDistinctChars(String S){
        HashMap<Character,Integer> hm = new HashMap<>();
        int count = 0;
        int left = 0;
        int a = 0;
        int ans = Integer.MIN_VALUE;
        
        for(int i = 0;i<S.length();i++){
            char ch = S.charAt(i);
            
            if(hm.containsKey(ch) && hm.get(ch)>=left){
                left = hm.get(ch)+1;
            }
            hm.put(ch,i);
            
            ans = Math.max(ans,i-left+1);
        }
        return ans;
    }
}