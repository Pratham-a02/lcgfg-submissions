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
            int N = Integer.parseInt(read.readLine());
            String S[] = read.readLine().split(" ");
            
            int[] a = new int[N];
            
            for(int i=0; i<N; i++)
                a[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.pyramidForm(a,N));
        }
    }
}
// } Driver Code Ends

class Solution{
    static int pyramidForm(int[] arr,int N){
        int left[] = new int[N];
        int right[] = new int[N];
 
    
        left[0] = Math.min(arr[0], 1);
 
    
        for(int i = 1; i < N; ++i)
        left[i] = Math.min(arr[i],Math.min(left[i - 1] + 1,i + 1));
                                          
    
        right[N - 1] = Math.min(arr[N - 1], 1);
    
        for(int i = N - 2; i >= 0; --i)
        right[i] = Math.min(arr[i],Math.min(right[i + 1] + 1,N - i));
                                            
        int tot[] = new int[N];
        for(int i = 0; i < N; ++i){
            tot[i] = Math.min(right[i], left[i]);
        }
    
        int max_ind = 0;
        for(int i = 0; i < N; ++i){
            if (tot[i] > tot[max_ind])
                max_ind = i;
        }
        int cost = 0;
        int height = tot[max_ind];
     
        for(int x = max_ind;x >= 0;x--){
            cost += arr[x] - height;
            if (height > 0)
                --height;
        }
     
        height = tot[max_ind] - 1;
        for(int x = max_ind + 1;x < N;x++){
            cost += arr[x] - height;
            if (height > 0)
                --height;
        }
        return cost;
    }
}