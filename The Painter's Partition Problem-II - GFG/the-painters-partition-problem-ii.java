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
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
    static long minTime(int[] arr,int n,int k){
        long lo = Integer.MIN_VALUE;
        long hi = 0;
        for(int num:arr){
            hi += num;
            lo = Math.max(lo,num);
        }
        
        while(lo<hi){
            long mid = (lo+hi)/2;
            long limit = mid;
            
            int partitions = 1;
            int csum = 0;
            for(int num:arr){
                if(csum + num <= limit){
                    csum += num;
                }
                else{
                    csum = num;
                    partitions++;
                }
            }
            
            if(partitions>k){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        return lo;
    }
}


