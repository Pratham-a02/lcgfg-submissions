class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->{
           return a[0] - b[0]; 
        });
        int st = intervals[0][0];
        int ed = intervals[0][1];
        
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0]<=ed){
                ed = Math.max(ed,intervals[i][1]);
            }
            else{
                ans.add(new int[]{st,ed});
                st = intervals[i][0];
                ed = intervals[i][1];
            }
        }
        
        ans.add(new int[]{st,ed});
        
        return ans.toArray(new int[0][]);
    }
}