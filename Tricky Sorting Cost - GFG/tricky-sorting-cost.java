//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.sortingCost(N, arr));
        }
    }
}
// } Driver Code Ends

class Solution{
    static int sortingCost(int N,int arr[]){
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int ele : arr){
            if(hm.containsKey(ele-1)){
                hm.put(ele,hm.get(ele-1)+1);
            }
            else{
                hm.put(ele,1);
            }
        }
        
        int max = Collections.max(hm.values());
        
        return N - max;
    }
}