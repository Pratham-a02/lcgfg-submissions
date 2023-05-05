class Solution{
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int dir = 0;
        int left = 0;
        int right = n-1;
        int top = 0;
        int down = m-1;
        
        while(left<=right && top<=down){
            if(dir == 0){
                for(int i = left;i<=right;i++){
                    ans.add(matrix[top][i]);
                }
                top++;
            }
            else if(dir == 1){
                for(int i = top;i<=down;i++){
                    ans.add(matrix[i][right]);
                }
                right--;
            }
            else if(dir == 2){
                for(int i = right;i>=left;i--){
                    ans.add(matrix[down][i]);
                }
                down--;
            }
            else if(dir == 3){
                for(int i = down;i>=top;i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir+1)%4;
        }
        
        return ans;
    }
}