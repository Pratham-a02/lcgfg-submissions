//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            int A[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for (int i = 0;i < n;i++)
            {
                A[i] = Integer.parseInt(s[i]);
            }
            int key = Integer.parseInt(in.readLine().trim());
            
            out.println(new Solution().search(A, 0, n - 1, key));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int search(int A[], int l, int h, int key){
        int lo = 0;
        int hi = A.length - 1;
        
        while(lo<hi){
            int mid = (lo+hi)/2;
            if(A[hi]<A[mid]){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        
        int one = findKey(A,key,0,lo-1);
        int two = findKey(A,key,lo,A.length-1);
        if(one != -1){
            return one;
        }
        else if(two != -1){
            return two;
        }
        else{
            return -1;
        }
    }
    
    public int findKey(int[] A,int key,int lo,int hi){
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(A[mid] == key){
                return mid;
            }
            if(A[mid]<key){
                lo = mid+1;
            }
            else{
                hi = mid-1;
            }
        }
        return -1;
    }
}