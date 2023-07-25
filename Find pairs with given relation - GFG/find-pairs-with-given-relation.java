//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends

class Solution{
    long findPairs(long a[],int n){
        HashSet<Long> hs = new HashSet<>();
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                long prod = a[i]*a[j];
                if(hs.contains(prod)){
                    return 1;
                }
                hs.add(prod);
            }
        }
        return -1;
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
            long a[]=new long[n];
            for(int  i=0;i<n;i++)
            {
                a[i]=Long.parseLong(a1[i]);
            }
            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.findPairs(a,n);
            System.out.println(ans);
        }
    }
}


//User function Template for Java



// } Driver Code Ends