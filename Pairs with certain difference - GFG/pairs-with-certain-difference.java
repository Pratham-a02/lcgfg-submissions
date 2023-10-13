//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[N];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int K = Integer.parseInt(br.readLine().trim());
            
            Solution obj = new Solution();
            System.out.println(obj.maxSumPairWithDifferenceLessThanK(arr, N, K));
            
        }
	}
}

// } Driver Code Ends

class Solution{ 
    public static int maxSumPairWithDifferenceLessThanK(int[] arr,int N,int K){
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            al.add(arr[i]);
        }
        
        Collections.sort(al);
        Collections.reverse(al);
        
        int sum = 0;
        int idx = 0;
        while(idx<N-1){
            int diff = al.get(idx) - al.get(idx+1);
            if(diff<K){
                sum += al.get(idx);
                sum += al.get(idx+1);
                idx+=2;
            }
            else{
                idx++;
            }
        }
        return sum;
    }
}
