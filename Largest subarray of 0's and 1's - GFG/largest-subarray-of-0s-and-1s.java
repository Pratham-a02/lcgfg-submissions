//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.util.HashMap;

class Largest_Subarray
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++) 
                a[i] = sc.nextInt();
            

            Solution g = new Solution();
            int n = g.maxLen(a, a.length);

            System.out.println(n);

            T--;
        }
    }
}

// } Driver Code Ends

class Solution{
    int maxLen(int[] arr,int N){
        int ps = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int max = 0;
        for(int i = 0;i<N;i++){
            int val = arr[i];
            
            if(val == 0){
                ps--;
            }
            else{
                ps++;
            }
            
            if(hm.containsKey(ps)){
                max = Math.max(max,i-hm.get(ps));
            }
            else{
                hm.put(ps,i);
            }
        }
        
        return max;
    }
}
