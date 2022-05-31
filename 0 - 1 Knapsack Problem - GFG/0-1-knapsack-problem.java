// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int[] wt, int[] val, int n){ 
         return solveknapSack(0,n,W,wt,val,new HashMap<String,Integer>()) ;
    } 
    private static int solveknapSack(int currIdx,int n,int W,int[] wt,int[] val,HashMap<String,Integer>hm){
        if(currIdx>=n){
            return 0;
        }
        
        String currKey = Integer.toString(currIdx) + "_" + Integer.toString(W);
        if(hm.containsKey(currKey))
            return hm.get(currKey);
        
        int taken = 0;
        if(wt[currIdx]<=W)
            taken = val[currIdx] + solveknapSack(currIdx+1,n,W-wt[currIdx],wt,val,hm);
        int notTaken = solveknapSack(currIdx+1,n,W,wt,val,hm);
        
        hm.put(currKey,Math.max(taken,notTaken));
        
        return Math.max(taken,notTaken);
    }
}


