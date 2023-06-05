class Solution{
    public boolean checkStraightLine(int[][] coordinates){
        int n = coordinates.length;
        for(int i = 0;i<n-1;i++){
            int xd = coordinates[i+1][0] - coordinates[i][0];
            int yd = coordinates[i+1][1] - coordinates[i][1];
            
            for(int j = i+2;j<n;j++){
                int xd_ = coordinates[j][0] - coordinates[i][0];
                int yd_ = coordinates[j][1] - coordinates[i][1];
                
                if(xd_ * yd != yd_ * xd){
                    return false;
                }
            }
        }
        return true;
    }
}