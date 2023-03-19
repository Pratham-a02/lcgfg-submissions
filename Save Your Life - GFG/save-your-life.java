//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution{
    static String maxSum(String w,char x[],int b[], int n){
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<x.length;i++){
            char ch = x[i];
            hm.put(ch,b[i]);
        }
        String ans = "";
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;
        int s = 0;
        for(int i = 0;i<w.length();i++){
            char ch = w.charAt(i);
            if(hm.containsKey(ch)){
                sum += hm.get(ch);
            }
            else{
                int asc_val = (int)ch;
                sum += asc_val;
            }
            
            if(sum>max){
                max = sum;
                start = s;
                end = i+1;
            }
            
            if(sum<0){
                sum = 0;
                s = i+1;
            }
        }
        
        return w.substring(start,end);
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String w = read.readLine();
            int n = Integer.parseInt(read.readLine());
            String TE[] = read.readLine().trim().split(" ");
            char x[] = new char[n];
            for(int i = 0;i<n;i++)
            {
                x[i] = TE[i].charAt(0);
            }
            
            String TR[] = read.readLine().trim().split(" ");
            int b[] = new int[n];
            for(int i = 0;i<n;i++)
            {
                b[i] = Integer.parseInt(TR[i]);
            }
           
            Solution ob = new Solution();
            System.out.println(ob.maxSum(w,x,b,n));
        }
    }
}
// } Driver Code Ends