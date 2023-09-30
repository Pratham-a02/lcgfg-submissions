//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0; i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.offerings(N, arr));
        }
    }
}
// } Driver Code Ends

class Solution{
    int offerings(int N,int[] arr){
        int[] ls = new int[N];
        int[] rs = new int[N];
        
        ls[0] = 1;
        rs[N-1] = 1;
        int counter = 1;
        
        for(int i = 1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                counter++;
                ls[i] = counter;
            }    
            else{
                counter = 1;
                ls[i] = counter;
            }
        }
        counter = 1;
        for(int i = N-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                counter++;
                rs[i] = counter;
            }
            else{
                counter = 1;
                rs[i] = counter;
            }
        }
        
        int ans = 0;
        for(int i = 0;i<N;i++){
            ans += Math.max(ls[i],rs[i]);
        }
        return ans;
    }
}