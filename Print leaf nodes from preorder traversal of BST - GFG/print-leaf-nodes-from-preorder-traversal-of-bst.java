//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int[] ans = ob.leafNodes(arr, N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution{
    public int[] leafNodes(int arr[],int N){
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        st.push(arr[0]);
        
        for(int i = 1;i<N;i++){
            if(arr[i] < st.peek()){
                st.push(arr[i]);
            }
            else{
                int temp = st.peek();
                int removed = 0;
                while(st.size()>0 && st.peek()<arr[i]){
                    st.pop();
                    removed++;
                }
                st.push(arr[i]);
                if(removed>=2){
                    al.add(temp);
                }
            }
        }
        al.add(st.peek());
        int[] ans = new int[al.size()];
        for(int i = 0;i<ans.length;i++){
            ans[i] = al.get(i);
        }
        return ans;
    }
}