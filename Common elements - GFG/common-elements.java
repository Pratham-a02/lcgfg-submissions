//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            
            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];
            
            for (int i = 0;i < n1;i++)
            {
                A[i] = sc.nextInt();
            }
            for (int i = 0;i < n2;i++)
            {
                B[i] = sc.nextInt();
            }
            for (int i = 0;i < n3;i++)
            {
                C[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            ArrayList<Integer> res = sol.commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0)
            {
                System.out.print(-1);
            }
            else 
            {
                for (int i = 0;i < res.size();i++)
                {
                    System.out.print(res.get(i) + " ");
                }    
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedHashMap<Integer,Integer> hm1 = new LinkedHashMap<>();
        LinkedHashMap<Integer,Integer> hm2 = new LinkedHashMap<>();
        LinkedHashMap<Integer,Integer> hm3 = new LinkedHashMap<>();
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<n1 && j<n2 && k<n3){
            hm1.put(A[i],hm1.getOrDefault(A[i],0)+1);
            hm2.put(B[j],hm2.getOrDefault(B[j],0)+1);
            hm3.put(C[k],hm3.getOrDefault(C[k],0)+1);
            
            i++;
            j++;
            k++;
        }
        while(i<n1){
            hm1.put(A[i],hm1.getOrDefault(A[i],0)+1);
            i++;
        } 
        while(j<n2){
            hm2.put(B[j],hm2.getOrDefault(B[j],0)+1);
            j++;
        }
        while(k<n3){
            hm3.put(C[k],hm3.getOrDefault(C[k],0)+1);
            k++;
        }
        
        for(int key:hm1.keySet()){
            if(hm2.containsKey(key) && hm3.containsKey(key)){
                ans.add(key);
            }
        }
        // Collections.sort(ans);
        return ans;
    }
}