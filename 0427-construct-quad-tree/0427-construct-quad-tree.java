/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/
class Solution {
    public Node construct(int[][] grid) {
        return dfs(grid,grid.length,0,0);
        
    }
    Node dfs(int[][] grid, int N, int n, int m) {
        boolean same = true;
        for (int i=0;i<N&&same;i++)
            for (int j=0;j<N&&same;j++)
                if ( grid[n][m] != grid[n+i][m+j] )
                    same = false;
        if ( same )
            return new Node(grid[n][m]==1, true);
        
        N/=2;
        Node tl = dfs(grid,N,n,m);
        Node tr = dfs(grid,N,n,m+N);
        Node bl = dfs(grid,N,n+N,m);
        Node br = dfs(grid,N,n+N,m+N);
        return new Node(false,false,tl,tr,bl,br);
    }
}


