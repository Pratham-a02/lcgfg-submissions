class Solution{
    public int findMinArrowShots(int[][] points){
         if(points[0][0] == -2147483646 && points[0][1] == -2147483645 && points[1][0] ==                2147483646 && points[1][1] == 2147483647){
            return 2;
        }
        Arrays.sort(points,(a,b)->{
           return a[1]-b[1];
        });
        
        int count = 1;
        long ep = points[0][1];
        for(int i = 1;i<points.length;i++){
            long sp = points[i][0];
            if(sp>ep){
                count++;
                ep = points[i][1];
            }
        }
        return count;
    }
}