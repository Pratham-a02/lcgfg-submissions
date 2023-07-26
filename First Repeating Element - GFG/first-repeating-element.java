//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) {

        // Taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // Taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total count of elements
            int n = sc.nextInt();

            // creating a new array of size n
            int arr[] = new int[n];

            // inserting elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            // calling firstRepeated method
            // and printing the result
            System.out.println(ob.firstRepeated(arr, n));
        }
    }
}
// } Driver Code Ends

class Solution{
    public static int firstRepeated(int[] arr,int n){
        LinkedHashMap<Integer,Integer> hm = new LinkedHashMap<>();
        for(int ele:arr){
            hm.put(ele,hm.getOrDefault(ele,0)+1);
        }
        
        int count = 1;
        for(int key:hm.keySet()){
            if(hm.get(key)>1){
                return count;
            }
            else{
                count++;
            }
        }
        return -1;
    }
}
