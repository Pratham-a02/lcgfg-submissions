//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends

class Solution{
    boolean checkIsAP(int arr[] ,int n){
        HashSet<Integer> hs = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int val : arr){
            hs.add(val);
            min = Math.min(min,val);
            max = Math.max(max,val);
        }
        
        int d = (max-min)/(n-1);
        
        if(d == 0){
            if(hs.size() == 1){
                return true;
            }
            else{
                return false;
            }
        }
        
        for(int i = 0;i<n;i++){
            int val = min + (i*d);
            
            if(!hs.contains(val)){
                return false;
            }
        }
        return true;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            int n=Integer.parseInt(br.readLine());

            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int a[]=new int[n];
            for(int  i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(a1[i]);
            }
            Solution ob=new Solution();

            boolean ans=ob.checkIsAP(a,n);
            if(ans==true)
            System.out.println("YES");
            else
            System.out.println("NO");
        }
    }
}




// } Driver Code Ends