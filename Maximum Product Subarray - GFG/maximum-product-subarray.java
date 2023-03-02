//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    public long maxProduct(int[] arr, int n) {
        long max = Integer.MIN_VALUE;
        long prod = 1;
        for(int i = 0;i<n;i++){
            prod = prod*arr[i];
            max = Math.max(max,prod);
            if(prod == 0){
                prod = 1;
            }
        }
        
        prod = 1;
        for(int i = n-1;i>=0;i--){
            prod = prod*arr[i];
            max = Math.max(max,prod);
            if(prod == 0){
                prod = 1;
            }
        }
        
        return max;
    }
}