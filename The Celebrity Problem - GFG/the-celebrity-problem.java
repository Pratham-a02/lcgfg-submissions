//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends
class Solution{ 
    int celebrity(int M[][], int n){
    	Stack<Integer> st = new Stack<>();
    	for(int i = 0;i<n;i++){
    	    st.push(i);
    	}
    	
    	while(st.size()>=2){
    	    int i = st.pop();
    	    int j = st.pop();
    	    
    	    if(M[i][j] == 1){
    	        st.push(j);
    	    }
    	    else{
    	        st.push(i);
    	    }
    	}
    	
    	if(st.size() == 0){
    	    return -1;
    	}
    	
    	int pot = st.pop();
    	for(int i = 0;i<n;i++){
    	    if(i!=pot){
    	        if(M[pot][i] == 1 || M[i][pot] == 0){
    	            return -1;
    	        }
    	    }
    	}
    	return pot;
    }
}