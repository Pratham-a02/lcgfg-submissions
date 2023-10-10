//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    Arrays.sort(arr);
		    Complete obj = new Complete();
		    int ans = obj.maximizeSum(arr, sizeOfArray);
		    System.out.println(ans);
		}
	}
}




// } Driver Code Ends

class Complete{
    public static int maximizeSum(int[] arr,int n){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int val : arr){
            hm.put(val,hm.getOrDefault(val,0)+1);
        }
        
        int ans = 0;
        
        for(int i = n-1;i>=0;i--){
            int val = arr[i];
            int valm1 = arr[i] - 1;
            
            if(!hm.containsKey(val)){
                continue;
            }
            else{
                hm.put(val,hm.get(val)-1);
                if(hm.containsKey(valm1)){
                    hm.put(valm1,hm.get(valm1)-1);
                    if(hm.get(valm1) == 0){
                        hm.remove(valm1);
                    }
                }
                
                if(hm.get(val) == 0){
                    hm.remove(val);
                }
                
                ans += val;
            }
            
        }
        return ans;
    }
}


