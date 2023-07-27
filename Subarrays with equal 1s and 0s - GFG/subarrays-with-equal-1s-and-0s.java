//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] arr= new int[n];
	       for(int i=0;i<n;i++) {
	           arr[i] = in.nextInt();
	       }
	       System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
	   }
	 }
}


// } Driver Code Ends

class Solution{
    static int countSubarrWithEqualZeroAndOne(int arr[],int n){
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int ps = 0;
        
        int ans = 0;
        for(int i = 0;i<n;i++){
            int val = arr[i];
            
            if(val == 0){
                ps--;
            }
            else{
                ps++;
            }
            
            if(hm.containsKey(ps)){
                ans += hm.get(ps);
            }
            
            hm.put(ps,hm.getOrDefault(ps,0)+1);
        }
        return ans;
    }
}


