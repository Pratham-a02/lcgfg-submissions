class Solution {
    public int[][] generateMatrix(int n){
        int[][] mat = new int[n][n];
        List<Integer> ans = new ArrayList<>();
        int top = 0;
        int left = 0;
        int down = n-1;
        int right = n-1;
        int dir = 0;
        int x = 1;
        while(left<=right && top<=down){
            if(dir == 0){
                for(int i = left;i<=right;i++){
                        mat[top][i] = x;
                        x++;
                    }
                    top++;
                }
            else if(dir == 1){
                for(int j = top;j<=down;j++){
                    mat[j][right] = x;
                    x++;
                }
                right--;
            }
            else if(dir == 2){
                for(int i = right;i>=left;i--){
                    mat[down][i] = x;
                    x++;
                }
                down--;
            }
            else if(dir == 3){
                for(int i = down;i>=top;i--){
                    mat[i][left] = x;
                    x++;
                }
                left++;
            }
            
            dir = (dir+1)%4;
        }
        return mat;
    }
}