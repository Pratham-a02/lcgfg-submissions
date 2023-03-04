//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    int K = Integer.parseInt(br.readLine());
		    
		    Complete obj = new Complete();
		    int ans = obj.minSwap(arr, sizeOfArray, K);
		    System.out.println(ans);
		}
	}
}

// } Driver Code Ends


//User function Template for Java



class Complete{
    public static int minSwap (int nums[], int n, int k) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            if(nums[i]<=k){
                count++;
            }
        }
        
        int left = 0;
        int bad = 0;
        
        for(int right = 0;right<n;right++){
            
            if(nums[right] >k){
                bad++;
            }
            
            while(right-left+1>count){
                if(nums[left]>k){
                    bad = bad-1;
                    left++;
                }
                else{
                    left++;
                }
            }
            
            if(right - left + 1 == count){
                min = Math.min(min,bad);
            }
        }
        return min;
    }
}
