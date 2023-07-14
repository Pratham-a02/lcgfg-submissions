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
    
        
        static long inversionCount(long arr[], long N){
            ans = 0;
            mergeSort(0,arr.length-1,arr);
            return ans;
        }
        
        public static long[] mergeSort(int lo,int hi,long[] arr){
            if(lo == hi){
                long[] barr = new long[1];
                barr[0] = arr[lo];
                return barr;
            }
            
            int mid = (lo+hi)/2;
            
            long[] lh = mergeSort(lo,mid,arr);
            long[] rh = mergeSort(mid+1,hi,arr);
            
            long[] farr =  mergeTwo(lh,rh);
            return farr;
        }
        
        public static long[] mergeTwo(long[] lh,long[] rh){
            long[] farr = new long[lh.length + rh.length];
            
            int i = 0;
            int j = 0;
            int k = 0;
            while(i<lh.length && j<rh.length){
                if(lh[i]<rh[j]){
                    farr[k] = lh[i];
                    i++;
                    k++;
                }
                else if(lh[i]>rh[j]){
                    ans += lh.length - i;
                    farr[k] = rh[j];
                    j++;
                    k++;
                }
            }
            
            while(i<lh.length){
                farr[k] = lh[i];
                i++;
                k++;
            }
            while(j<rh.length){
                farr[k] = rh[j];
                j++;
                k++;
            }
            return farr;
        }
    }