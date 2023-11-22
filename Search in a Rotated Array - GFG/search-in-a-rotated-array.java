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

class Solution{
    int search(int[] A,int l,int h,int key){
        while(l<h){
            int mid = (l+h)/2;
            if(A[mid]>A[h]){
                l = mid+1;
            }
            else{
                h = mid;
            }
        }
        int la = solve(0,l-1,A,key);
        int ra = solve(l,A.length-1,A,key);
        
        if(la == -1 && ra == -1){
            return -1;
        }
        else if(la == -1 && ra != -1){
            return ra;
        }
        else{
            return la;
        }
    }
    
    public static int solve(int l,int h,int[] A,int target){
        while(l<=h){
            int mid = (l+h)/2;
            if(A[mid] == target){
                return mid;
            }
            if(A[mid]<target){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return -1;
        
    }
}