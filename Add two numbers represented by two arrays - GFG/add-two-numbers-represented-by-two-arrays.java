//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    String calc_Sum(int[] a,int n,int[] b,int m){
        int len = n>m?n:m;
        int[] c = new int[len];
        
        int i = a.length-1;
        int j = b.length-1;
        int k = c.length-1;
        int carry = 0;
        while(i>=0 && j>=0 && k>=0){
            int csum = a[i] + b[j] + carry;
            int val = csum%10;
            carry = csum/10;
            c[k] = val;
            i--;
            j--;
            k--;
        }
        
        while(i>=0 && k>=0){
            int csum = a[i] + carry;
            int val = csum%10;
            carry = csum/10;
            c[k] = val;
            i--;
            k--;
        }
        while(j>=0 && k>=0){
            int csum = b[j] + carry;
            int val = csum%10;
            carry = csum/10;
            c[k] = val;
            j--;
            k--;
        }
        
        String ans = "";
        for(int x = 0;x<c.length;x++){
            ans += c[x];
        }
        
        if(carry != 0){
            ans = carry + ans;
        }
        
        if(ans.charAt(0) == '0'){
            return ans.substring(1);
        }
        else{
            return ans;
        }
    }
}


//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray_N = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray_N];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray_N;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    String line2 = br.readLine();
		    String[] ele = line2.trim().split("\\s+");
		    int sizeOfArray_M = Integer.parseInt(ele[0]);
		    
		    int brr [] = new int[sizeOfArray_M];
		    
		    line2 = br.readLine();
		    String[] elements2 = line2.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray_M;i++){
		        brr[i] = Integer.parseInt(elements2[i]);
		    }
		    
		    Solution obj = new Solution();
		   
		    String res = obj.calc_Sum(arr, sizeOfArray_N, brr, sizeOfArray_M);
		    
		    System.out.println(res);
		    
		    
		}
	}
}


            


// } Driver Code Ends