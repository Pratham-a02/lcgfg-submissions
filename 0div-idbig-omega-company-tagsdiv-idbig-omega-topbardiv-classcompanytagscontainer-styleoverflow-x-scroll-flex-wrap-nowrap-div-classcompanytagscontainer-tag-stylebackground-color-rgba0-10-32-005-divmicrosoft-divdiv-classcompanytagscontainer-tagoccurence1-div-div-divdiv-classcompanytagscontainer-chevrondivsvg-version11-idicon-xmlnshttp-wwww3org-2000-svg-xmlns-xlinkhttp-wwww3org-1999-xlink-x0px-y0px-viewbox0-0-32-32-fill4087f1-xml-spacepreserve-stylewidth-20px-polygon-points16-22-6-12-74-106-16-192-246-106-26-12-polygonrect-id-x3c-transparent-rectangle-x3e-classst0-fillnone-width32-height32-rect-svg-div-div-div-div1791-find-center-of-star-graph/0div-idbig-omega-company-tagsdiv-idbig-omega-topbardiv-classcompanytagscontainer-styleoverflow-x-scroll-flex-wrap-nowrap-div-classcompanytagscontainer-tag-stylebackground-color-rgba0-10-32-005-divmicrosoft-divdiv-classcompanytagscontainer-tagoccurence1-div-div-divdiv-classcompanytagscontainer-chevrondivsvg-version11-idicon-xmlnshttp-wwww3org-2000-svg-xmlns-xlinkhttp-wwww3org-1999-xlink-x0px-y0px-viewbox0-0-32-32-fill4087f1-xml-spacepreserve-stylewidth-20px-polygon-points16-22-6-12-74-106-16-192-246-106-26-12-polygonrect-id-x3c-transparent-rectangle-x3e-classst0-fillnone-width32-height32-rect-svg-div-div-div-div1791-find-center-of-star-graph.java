class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length+1;
        
        int[] curr = edges[0];
        int[] next = edges[1];

        int a = curr[0];
        int b = curr[1];
        int c = next[0];
        int d = next[1];
        
        if(a == c || a == d){
            return a;
        }
        else if(b == c || b == d){
            return b;
        }
        else{
            return -1;
        }
    }
}