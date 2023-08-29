//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a){
            if(e==Integer.MIN_VALUE)
              System.out.print("INF ");
            else
              System.out.print(e+" ");
        }
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a){
            if(e==Integer.MIN_VALUE)
              System.out.print("INF ");
            else
              System.out.print(e+" ");
        }
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int v; 
            v = Integer.parseInt(br.readLine());
            
            
            int e; 
            e = Integer.parseInt(br.readLine());
            
            
            int src; 
            src = Integer.parseInt(br.readLine());
            
            
            int[][] edges = IntMatrix.input(br, e, 3);
            
            Solution obj = new Solution();
            int [] res = obj.maximumDistance(v, e, src, edges);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {
    public static int [] maximumDistance(int v, int e, int src, int[][] edges) {
        // code here
        ArrayList<Pair>[] graph = new ArrayList[v];
        
        for(int i=0;i<v;i++)
        graph[i] = new ArrayList<>();
        
        for(int []ed : edges){
            int u = ed[0];
            int ve = ed[1];
            int wt = ed[2];
            
            graph[u].add(new Pair(ve,wt));
        }
        
        boolean[] vis = new boolean[v];
        int[] dist = new int[v];
        Arrays.fill(dist,Integer.MIN_VALUE);
        
        Stack<Integer> st = new Stack<>();
        topoSort(src,graph,vis,st);
        
        dist[src] = 0;
        
        while(!st.isEmpty()){
            Integer curr = st.pop();
            
            for(Pair nbr : graph[curr]){
                if(dist[curr] + nbr.wt > dist[nbr.v]){
                    dist[nbr.v] = dist[curr] + nbr.wt;
                }
            }
        }
        
        return dist;
    }
    private static void topoSort(int ver,ArrayList<Pair>[] graph,boolean[] vis,Stack<Integer> st){
        vis[ver] = true;
        
        for(Pair nbr : graph[ver]){
            if(!vis[nbr.v])
            topoSort(nbr.v,graph,vis,st);
        }
        
        st.push(ver);
    }
}

class Pair{
    int v,wt;
    public Pair(int v,int w){
        this.v = v;
        wt = w;
    }
}    