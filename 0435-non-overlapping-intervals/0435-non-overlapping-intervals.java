class Solution{
    public int eraseOverlapIntervals(int[][] intervals){
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->{
           return a[0]-b[0]; 
        });
        int count = 0;
        
        int i = 0;
        int j = 1;
        
        while(j<n){
            int cs = intervals[i][0];
            int ce = intervals[i][1];
            
            int ns = intervals[j][0];
            int ne = intervals[j][1];
            
            if(ce<=ns){
                i=j;
                j++;
            }
            else if(ce<=ne){
                j++;
                count++;
            }
            else if(ce>=ne){
                i=j;
                j++;
                count++;
            }
        }
        
        return count;
    }
}