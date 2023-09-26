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
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.maxSumBS(a, n));
            
        }
	}
}

// } Driver Code Ends

class Compute{
    public static int maxSumBS(int arr[],int n){
        int[] left = new int[n];
        int[] right = new int[n];
        
        for(int i = 0;i<n;i++){
            left[i] = arr[i];
            for(int j = i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    left[i] = Math.max(left[i],arr[i]+left[j]);
                }
            }
        }
        
        for(int i = n-1;i>=0;i--){
            right[i] = arr[i];
            for(int j = i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    right[i] = Math.max(right[i],arr[i]+right[j]);
                }
            }
        }
        
        int max = 0;
        for(int i = 0;i<n;i++){
            max = Math.max(max,left[i]+right[i]-arr[i]);
        }
        return max;
    }
}