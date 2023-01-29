//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static long ans = 0;
    public static long inversionCount(long arr[], long N){
        ans = 0;
        mergeSort(arr,0,arr.length-1);
        return ans;
    }
    
    public static long[] mergeSort(long[] arr,int lo,int hi){
        if(lo == hi){
            long[] ba = new long[1];
            ba[0] = arr[lo];
            return ba;
        }
        
        int mid = (lo+hi)/2;
        long[] lh = mergeSort(arr,lo,mid);
        long[] rh = mergeSort(arr,mid+1,hi);
        
        long[] farr = mergeArrays(lh,rh);
        return farr;
    }
    
    public static long[] mergeArrays(long[] arr1, long[] arr2){
        long[] res = new long[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<=arr2[j]){
                res[k] = arr1[i];
                k++;
                i++;
            }
            else{
                res[k] = arr2[j];
                ans += arr1.length - i;
                j++;
                k++;
            }
        }
        
        while(i<arr1.length){
            res[k] = arr1[i];
            k++;
            i++;
        }
        while(j<arr2.length){
            res[k] = arr2[j];
            k++;
            j++;
        }
        return res;
    }
}