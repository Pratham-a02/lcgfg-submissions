class Solution {

    public void dfs(int[][] land, int row, int col, int[] temp) {
        // base case
        if (row < 0 || row >= land.length || col < 0 || col >= land[0].length || land[row][col] == 0) return;

        // making as visited
        land[row][col] = 0;

        // making bottom right
        temp[2] = Math.max(temp[2], row);
        temp[3] = Math.max(temp[3], col);

        dfs(land, row - 1, col, temp); // go up
        dfs(land, row + 1, col, temp); // go down
        dfs(land, row, col - 1, temp); // go left
        dfs(land, row, col + 1, temp); // go right
    }

    public int[][] findFarmland(int[][] land) {
        // disconnected components
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    int[] temp = new int[4];
                    // making top left
                    temp[0] = i;
                    temp[1] = j;

                    dfs(land, i, j, temp);
                    ans.add(temp);
                }
            }
        }

        int[][] result = new int[ans.size()][4];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}