//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for (int i=0; i<n ; i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array, n); 

           	for (int i = 0; i < n; i++) { 
				System.out.print(ans[i]+" ");
			} 
            System.out.println();
            t--;
        }
    } 
} 
  


// } Driver Code Ends


//User function Template for Java


class Solution { 
	public static long[] productExceptSelf(int nums[], int n){ 
        long[] pass1 = new long[nums.length];
        long[] pass2 = new long[nums.length];
        
        pass1[0] = 1;
        pass2[pass2.length-1] = 1;
        
        
        for(int i = 1;i<nums.length;i++){
            pass1[i] = pass1[i-1]*nums[i-1];
        }
        
        for(int i = nums.length-2;i>=0;i--){
            pass2[i] = pass2[i+1]*nums[i+1];
        }
        
        long[] ans = new long[nums.length];
        for(int i = 0;i<ans.length;i++){
            ans[i] = pass1[i]*pass2[i];
        }
        return ans;
	} 
} 