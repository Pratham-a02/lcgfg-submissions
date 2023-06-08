class Solution {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        
        int i = 0;
        
        while(i<grid.length){
            int j = grid[i].length - 1;
            
            
            while(j>=0 && grid[i][j] < 0){
                j--;
            }
            j++;
            
            ans += grid[i].length - j;
            i++;
        }
        return ans;
    }
}