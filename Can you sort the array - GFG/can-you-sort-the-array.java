//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    public boolean canSort(int[] arr, int[] frozen) {
        int countZeroes = 0;
        
        for(int num:arr){
            if(num == 0) countZeroes++;
        }
        
        for(int i = 0;i<arr.length;i++){
            if(i<countZeroes && arr[i] == 1 && frozen[i] == 1){
                return false;
            }
            
            if(i>=countZeroes && arr[i] == 0 && frozen[i] == 1){
                return false;
            }
        }
        
        return true;
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Read number of test cases
        while (t-- > 0) {
            // Read the arr array
            String[] arrInput = br.readLine().split(" ");
            int[] arr = Arrays.stream(arrInput).mapToInt(Integer::parseInt).toArray();

            // Read the locked array
            String[] frozen = br.readLine().split(" ");
            int[] locked = Arrays.stream(frozen).mapToInt(Integer::parseInt).toArray();

            Solution solution = new Solution();
            boolean result = solution.canSort(arr, locked);
            System.out.println(result ? "true" : "false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends