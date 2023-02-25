//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int num = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[num];
            for(int i = 0; i < num; i++)
                arr[i] = sc.nextInt();
            
            ArrayList <Integer> res = new Solution().nearlySorted(arr, num, k);
            for (int i = 0; i < res.size (); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


class Solution{
    
    public ArrayList <Integer> nearlySorted(int arr[], int num, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                int val = pq.remove();
                ans.add(val);
            }
        }
        
        while(pq.size()>0){
            int val = pq.remove();
            ans.add(val);
        }
        return ans;
    }
}
