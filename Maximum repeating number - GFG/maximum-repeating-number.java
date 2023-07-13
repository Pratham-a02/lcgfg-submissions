//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().maxRepeating(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    int maxRepeating(int[] arr,int n,int k){
        int[] farr = new int[k];
        
        for(int i = 0;i<n;i++){
            int val = arr[i];
            
            farr[val]++;
        }
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int i = 0;i<farr.length;i++){
            if(farr[i] > max){
                max = farr[i];
                ans = i;
            }
        }
        return ans;
    }
}