//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findKRotation(int arr[], int n) {
        int lo = 0;
        int hi = n-1;
        
        while(lo<hi){
            int mid = (lo+hi)/2;
            
            if(arr[hi]<arr[mid]){
                lo = mid+1;
            }
            else if(arr[hi]>arr[mid]){
                hi = mid;
            }
        }
        if(lo>0){
            return lo;
        }
        else{
            return 0;
        }
    }
}