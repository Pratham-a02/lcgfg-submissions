class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
           return a[0]==b[0]?b[1]-a[1]:a[0]-b[0]; 
        });
        
        int count = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0]>=start && intervals[i][1]<=end){
                count++;
            }
            else{
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}