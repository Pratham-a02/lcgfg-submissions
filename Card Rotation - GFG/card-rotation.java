//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            Solution obj = new Solution();
            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = obj.rotation(N);
            for(int i: ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends

class Solution{
    public ArrayList<Integer> rotation(int N){
        ArrayDeque<Integer> qu = new ArrayDeque<>();
        for(int i = 1;i<=N;i++){
            qu.add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 1;
        int[] arr = new int[N+1];
        while(qu.size()>0){
            int j = 0;
            while(j<i){
                int x = qu.remove();
                qu.add(x);
                j++;
            }
            
            int x = qu.remove();
            if(arr[x] != 0){
                ans.add(-1);
                return ans;
            }
            arr[x] = i;
            i++;
        }
        
        for(int k = 1;k<arr.length;k++){
            ans.add(arr[k]);
        }
        return ans;
    }
}