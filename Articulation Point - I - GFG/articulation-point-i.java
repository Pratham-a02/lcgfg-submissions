//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution{
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj){
       int[] low = new int[V];
        int[] dis = new int[V];
        boolean[] vis = new boolean[V];
        boolean[] aps = new boolean[V];
        
        for(int v = 0;v<V;v++){
            if(vis[v] == false){
                dfs(adj,low,dis,vis,aps,v,-1);
            }
        }
        
        int count = 0;
        for(int i = 0;i<aps.length;i++){
            if(aps[i]){
                count++;
            }
        }
        if(count == 0){
            ArrayList<Integer> Ans = new ArrayList<>();
            Ans.add(-1);
            return Ans;
        }
        int[] ans = new int[count];
        int idx = 0;
        for(int i = 0;i<aps.length;i++){
            if(aps[i] == true){
                ans[idx] = i;
                idx++;
            }
        }
        
        ArrayList<Integer> fAns = new ArrayList<>();
        for(int i = 0;i<ans.length;i++){
            fAns.add(ans[i]); 
        }
        return fAns;
    }
    int time = 0;
    public void dfs(ArrayList<ArrayList<Integer>> adj,int[] low,int[] dis,boolean[] visited,boolean[] aps,int currVert,int parent){
        visited[currVert] = true;
        dis[currVert] = low[currVert] = ++time;
        
        int count = 0;
        for(int nbr:adj.get(currVert)){
            if(nbr == parent){
                continue;
            }
            else if(visited[nbr] == true){
                low[currVert] = Math.min(low[currVert],dis[nbr]);
            }
            else{
                count++;
                dfs(adj,low,dis,visited,aps,nbr,currVert);
                low[currVert] = Math.min(low[currVert],low[nbr]);
                
                if(parent != -1 && low[nbr]>=dis[currVert]){
                    aps[currVert] = true;
                }
            }
        }
        
        if(parent == -1 && count >1){
            aps[currVert] = true;
        }
    }
}