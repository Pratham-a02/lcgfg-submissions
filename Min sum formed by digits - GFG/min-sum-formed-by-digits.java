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
            
            Solution obj = new Solution();
            System.out.println(obj.minSum(a, n));
            
        }
	}
}


// } Driver Code Ends

class Solution{
    public static long minSum(int[] arr,int n){
        long num1 = 0;
        long num2 = 0;
        Arrays.sort(arr);
        for(int i = 0;i<n;i+=2){
            num1 = num1*10 + arr[i];
        }
        for(int i = 1;i<n;i+=2){
            num2 = num2*10 + arr[i];
        }
        
        return num1 + num2;
    }
}