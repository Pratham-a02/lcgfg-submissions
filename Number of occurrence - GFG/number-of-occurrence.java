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
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x){
        int count = 0;
        int lo = 0;
        int hi = n-1;
        int fi = -1;
        int li = -1;
        while(lo<=hi){
            int mid = lo - (lo-hi)/2;
            
            if(arr[mid] == x){
                fi = mid;
                hi = mid-1;
            }
            else if(arr[mid]>x){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        lo = 0;
        hi = n-1;
        while(lo<=hi){
            int mid = lo - (lo-hi)/2;
            
            if(arr[mid] == x){
                li = mid;
                lo = mid+1;
            }
            else if(arr[mid]>x){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        if(li == -1 && fi == -1){
            return 0;
        }
        return li-fi+1;
    }
}