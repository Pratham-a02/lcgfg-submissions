class Solution {
public:
 
    // Time Complexity:- O(N^2) --> ACCEPTED
    // Space Complexity:- O(N^2)
 
    int orderOfLargestPlusSign(int n, vector<vector<int>>& mines) {
        vector<vector<int>> mat(n,vector<int>(n,1)); // used to store the matrix
        vector<vector<int>> left(n,vector<int>(n,1)); // left[i][j] = longest consecutive +  from leftwards ending at (i,j)
        vector<vector<int>> right(n,vector<int>(n,1)); // right[i][j] = longest consecutive + from rightwards ending at (i,j)
        vector<vector<int>> up(n,vector<int>(n,1)); // up[i][j] = longest consecutive + from upwards ending at (i,j)
        vector<vector<int>> down(n,vector<int>(n,1)); // down[i][j] = longest consecutive + from downwards ending at (i,j)
        for(auto c:mines)
            mat[c[0]][c[1]] = left[c[0]][c[1]] = right[c[0]][c[1]] = up[c[0]][c[1]] = down[c[0]][c[1]] = 0;
        for(int i=0;i<n;i++){ // fill up the all required above 2D vectors
            for(int j=1;j<n;j++){
                left[i][j] = mat[i][j]?1+left[i][j-1]:0;
                down[j][i] = mat[j][i]?1+down[j-1][i]:0;
            }
            for(int j=n-2;j>=0;j--){
                right[i][j] = mat[i][j]?1+right[i][j+1]:0;
                up[j][i] = mat[j][i]?1+up[j+1][i]:0;
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]) // find answer for every cell being considered as centre of plus sign
                    ans = max(ans,min(min(left[i][j],right[i][j]),min(up[i][j],down[i][j])));
            }
        }
        return ans;
    }
};