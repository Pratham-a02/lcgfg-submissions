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
        Stack<Integer> st = new Stack<>();
        boolean[] vis1 = new boolean[V];
        for(int v = 0;v<V;v++){
            if(vis1[v] == false){
                dfs1(v,adj,st,vis1);
            }
        }
        ArrayList<ArrayList<Integer>> tsp = new ArrayList<>();
        for(int v = 0;v<V;v++){
            tsp.add(new ArrayList<>());
        }
        
        for(int v = 0;v<V;v++){
            for(int nbr:adj.get(v)){
                tsp.get(nbr).add(v);
            }
        }
        boolean[] vis2 = new boolean[V];
        int count = 0;
        while(st.size()>0){
            int vert = st.pop();
            if(vis2[vert] == false){
                dfs2(vert,tsp,vis2);
                count++;
            }
        }
        return count;
    }
    
    public void dfs2(int vert,ArrayList<ArrayList<Integer>> tsp,boolean[] vis){
        vis[vert] = true;
        for(int nbr:tsp.get(vert)){
            if(vis[nbr] == false){
                dfs2(nbr,tsp,vis);
            }
        }
        return;
    }
    
    public void dfs1(int v,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,boolean[] vis){
        vis[v] = true;
        
        for(int nbr:adj.get(v)){
            if(vis[nbr] == false){
                dfs1(nbr,adj,st,vis);
            }
        }
        
        st.push(v);
    }
}
