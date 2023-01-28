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
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
                {
                    int x = sc.nextInt();
                    arr.add(x);
                }
            int m = sc.nextInt();
            
            Solution ob = new Solution();
            
    		System.out.println(ob.findMinDiff(arr,n,m));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public long findMinDiff (ArrayList<Integer> a, int n, int m){
        int min = Integer.MAX_VALUE;
        int left = 0;
        Collections.sort(a);
        for(int right = 0;right<a.size();right++){
            
            while(right-left+1>m){
                left++;
            }
            
            if(right - left+1 == m){
                min = Math.min(min,a.get(right)-a.get(left));
            }
        }
        return min;
    }
}