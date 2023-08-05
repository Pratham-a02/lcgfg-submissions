//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String N = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.LargestSwap(N));
        }
    }
}
// } Driver Code Ends

class Solution{
    String LargestSwap(String S){
        char[] arr = S.toCharArray();
        
        int[] maxArr = new int[S.length()];
        int n = arr.length;
        
        for(int i = n-2;i>=0;i--){
            if(i == n-1){
                maxArr[i] = -1;
                continue;
            }
            else if(i == n-2){
                maxArr[i] = n-1;
                continue;
            }
            
            if(arr[i+1] > arr[maxArr[i+1]]){
                maxArr[i] = i+1;
            }
            else{
                maxArr[i] = maxArr[i+1];
            }
        }
        
        for(int i = 0;i<n-1;i++){
            if(arr[i] < arr[maxArr[i]]){
                char temp = arr[i];
                arr[i] = arr[maxArr[i]];
                arr[maxArr[i]] = temp;
                break;
            }
        }
        return String.valueOf(arr);
    }
}