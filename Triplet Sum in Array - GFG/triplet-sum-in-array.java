//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int X = Integer.parseInt(inputLine[1]);
		    int A[] = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        A[i] = Integer.parseInt(inputLine[i]);
		    }
		    Solution ob=new Solution();
		    boolean ans = ob.find3Numbers(A, n, X);
		    System.out.println(ans?1:0);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static boolean find3Numbers(int[] arr, int n, int X) { 
        Arrays.sort(arr);
        int i = 0;
        for(i = 0;i<arr.length-2;i++){
            if(i == 0 || arr[i] != arr[i-1]){
                int lo = i+1;
                int hi = n-1;
                int target = X - arr[i];
                while(lo<hi){
                    if(arr[lo]+arr[hi] == target){
                        return true;
                    }
                    else if(arr[lo]+arr[hi]>target){
                        hi--;
                    }
                    else{
                        lo++;
                    }
                }
            }
        }
        return false;
    }
}
