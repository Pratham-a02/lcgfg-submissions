//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends

class Solution{
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis1 = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int v = 0;v<V;v++){
            if(!vis1[v]){
                dfs(v,adj,st,vis1);
            }
        }
        
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        
        for(int v = 0;v<V;v++){
            adj1.add(new ArrayList<>());
        }
        
        for(int v = 0;v<V;v++){
            for(int nbr:adj.get(v)){
                adj1.get(nbr).add(v);
            }
        }
        
        boolean[] vis2 = new boolean[V];
        int count = 0;
        while(st.size()>0){
            int v = st.pop();
            if(!vis2[v]){
                dfs_(v,adj1,vis2);
                count++;
            }
        }
        return count;
    }
    
    public void dfs_(int v,ArrayList<ArrayList<Integer>> adj1,boolean[] vis2){
        vis2[v] = true;
        
        for(int nbr:adj1.get(v)){
            if(!vis2[nbr]){
                dfs_(nbr,adj1,vis2);
            }
        }
    }
    
    public void dfs(int v,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,boolean[] vis){
        vis[v] = true;
        
        for(int nbr:adj.get(v)){
            if(!vis[nbr]){
                dfs(nbr,adj,st,vis);
            }
        }
        st.push(v);
        
        return;
    }
}
