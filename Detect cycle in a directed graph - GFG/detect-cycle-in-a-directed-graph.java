//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    int[] vis;
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj){
        boolean ans = false;
        vis = new int[V];
        for(int v = 0;v<V;v++){
            boolean isCycle = dfs(v,adj);
            if(isCycle){
                ans = true;
            }
        }
        return ans;
    }
    
    public boolean dfs(int v,ArrayList<ArrayList<Integer>> adj){
        if(vis[v] == 2){
            return false;
        }
        if(vis[v] == 1){
            return true;
        }
        else{
            vis[v] = 1;
            for(int nbr:adj.get(v)){
                boolean isPossible = dfs(nbr,adj);
                
                if(isPossible){
                    return true;
                }
            }
            vis[v] = 2;
            return false;
        }
    }
}