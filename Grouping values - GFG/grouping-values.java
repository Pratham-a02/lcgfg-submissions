//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int K = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isPossible(N, arr, K));
        }
    }
}

// } Driver Code Ends

class Solution{
    static int isPossible(int N,int arr[],int K){
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int ele : arr){
            hm.put(ele,hm.getOrDefault(ele,0)+1);
        }
        
        for(int val : hm.values()){
            if(val > 2*K){
                return 0;
            }
        }
        return 1;
    }
}