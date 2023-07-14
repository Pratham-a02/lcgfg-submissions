//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int[] ans = new Solution().findSurpasser(arr, n);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends

class Pair{
    int idx;
    int val;
    
    Pair(int idx,int val){
        this.idx = idx;
        this.val = val;
    }
}

class Solution{
    int[] res;
    int[] findSurpasser(int[] arr,int n){
        Pair[] pairs = new Pair[n];
        
        for(int i = 0;i<n;i++){
            pairs[i] = new Pair(i,arr[i]);
        }
        res = new int[n];
        mergeSort(pairs,0,n-1);
        return res;
    }
    
    public Pair[] mergeSort(Pair[] pairs,int lo,int hi){
        if(lo == hi){
            Pair[] bp = new Pair[1];
            bp[0] = new Pair(lo,pairs[lo].val);
            return bp;
        }
        
        int mid = (lo+hi)/2;
        
        Pair[] lp = mergeSort(pairs,lo,mid);
        Pair[] rp = mergeSort(pairs,mid+1,hi);
        
        Pair[] fp = mergeTwo(lp,rp);
        
        return fp;
    }
    
    public Pair[] mergeTwo(Pair[] lp,Pair[] rp){
        Pair[] ret = new Pair[lp.length + rp.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i<lp.length && j<rp.length){
            if(lp[i].val < rp[j].val){
                res[lp[i].idx] += (rp.length-j);
                ret[k] = lp[i];
                i++;
                k++;
            }
            else{
                ret[k] = rp[j];
                j++;
                k++;
            }
        }
        
        while(i<lp.length){
            ret[k] = lp[i];
            i++;
            k++;
        }
        while(j<rp.length){
            ret[k] = rp[j];
            j++;
            k++;
        }
        
        return ret;
    }
    
    
}
