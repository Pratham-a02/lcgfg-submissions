class Solution{
    public int[][] spiralMatrixIII(int rows,int cols,int rstart,int cstart){
        int[][] ans = new int[rows*cols][2];
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        
        ans[0] = new int[]{rstart,cstart};
        int count = 1;
        int steps = 0;
        int dir = 0;
        
        while(count < rows*cols){
            if(dir == 0 || dir == 2){
                steps++;
            }
            
            for(int i = 0;i<steps;i++){
                rstart += dirs[dir][0];
                cstart += dirs[dir][1];
                
                if(rstart >= 0 && rstart < rows && cstart >= 0 && cstart < cols){
                    ans[count++] = new int[]{rstart,cstart};
                }
            }
            dir = (dir+1)%4;
        }
        return ans;
    }
}