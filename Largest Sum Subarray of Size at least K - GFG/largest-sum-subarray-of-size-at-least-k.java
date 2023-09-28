//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Compute obj = new Compute();
            System.out.println(obj.maxSumWithK(a, n, k));
            
        }
	}
}


// } Driver Code Ends

class Compute{
    public long maxSumWithK(long a[],long n,long k){
        long ans = Integer.MIN_VALUE;
        
        long[] maxSum = new long[a.length];
        maxSum[0] = a[0];
        long csum = a[0];
        
        for(int i = 1;i<n;i++){
            if(csum>0){
                csum += a[i];
            }
            else{
                csum = a[i];
            }
            
            maxSum[i] = csum;
        }
        
        int left = 0;
        csum = 0;
        for(int right = 0;right<n;right++){
            csum += a[right];
            
            if(right - left + 1 == k){
                ans = Math.max(ans,csum);
                
                if(left-1>=0){
                    ans = Math.max(ans,csum+maxSum[left-1]);
                }
                csum -= a[left];
                left++;
            }
        }
        return ans;
    }
}