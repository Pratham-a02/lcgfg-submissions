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
    int celebrity(int[][] M,int n){
    	Stack<Integer> st = new Stack<>();
    	for(int i = 0;i<n;i++){
    	    st.push(i);
    	}
    	
    	while(st.size()>=2){
    	    int i = st.pop();
    	    int j = st.pop();
    	    
    	    if(M[i][j] == 0 && M[j][i] == 1){
    	        st.push(i);
    	    }
    	    else if(M[j][i] == 0 && M[i][j] == 1){
    	        st.push(j);
    	    }
    	}
    	if(st.size() == 0){
    	    return -1;
    	}
    	int cele = st.pop();
    	
    	for(int i = 0;i<n;i++){
    	    if(i != cele){
    	        if(M[i][cele] == 0 || M[cele][i] == 1){
    	            return -1;
    	        }
    	    }
    	}
    	return cele;
    }
}