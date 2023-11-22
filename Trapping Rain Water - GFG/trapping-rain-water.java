//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends

class Solution{
    static long trappingWater(int[] arr,int n){ 
        long left = 0;
        long right = 0;
        int l = 0;
        int r = n-1;
        long ans = 0;
        while(l<r){
            if(arr[l]<=arr[r]){
                if(left<=arr[l]){
                    left = arr[l];
                }
                else{
                    ans += (left - arr[l]);
                }
                l++;
            }
            else if(arr[r]<=arr[l]){
                if(right <= arr[r]){
                    right = arr[r];
                }
                else{
                    ans += (right - arr[r]);
                }
                r--;
            }
        }
        return ans;
    } 
}


