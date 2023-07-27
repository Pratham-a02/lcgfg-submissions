//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends

class Solution{
    public int longestkSubstr(String s,int k){
        int left = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int n = s.length();
        int max = -1;
        
        for(int right = 0;right<n;right++){
            char ch = s.charAt(right);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            
            while(hm.size()>k){
                char c = s.charAt(left);
                hm.put(c,hm.get(c)-1);
                if(hm.get(c) == 0){
                    hm.remove(c);
                }
                left++;
            }
            
            if(hm.size() == k){
                max = Math.max(max,right-left+1);  
            }
        }
        return max;
    }
}