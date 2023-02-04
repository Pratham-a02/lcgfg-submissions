class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for(int[] arr:grid){
            Arrays.sort(arr);
        }
        int ans = 0;
        
        for(int j = 0;j<grid[0].length;j++){
            int max = Integer.MIN_VALUE;
            for(int i = 0;i<grid.length;i++){
                max = Math.max(grid[i][j],max);
            }
            ans += max;
        }
        return ans;
    }
}