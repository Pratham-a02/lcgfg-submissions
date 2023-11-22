//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().smallestSumSubarray(arr, n)); 
        }
    }
}

// } Driver Code Ends

class Solution{
    static int smallestSumSubarray(int[] a,int size){
        int min = Integer.MAX_VALUE;
        int curr = 0;
        for(int i = 0;i<a.length;i++){
            curr += a[i];
            min = Math.min(min,curr);
            if(curr>0){
                curr = 0;
            }
        }
        return min;
    }
}