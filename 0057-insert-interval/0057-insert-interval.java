class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval){
        List<int[]> al = new ArrayList<>();
        for(int[] arr:intervals){
            al.add(arr);
        }
        
        al.add(newInterval);
        
        List<int[]> ans = merge(al.toArray(new int[0][]));
        
        return ans.toArray(new int[0][]);
        
    }
    
    public List<int[]> merge(int[][] intervals){
        List<int[]> al = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int[] arr:intervals){
            if(arr[0]<=end){
                end = Math.max(end,arr[1]);
            }
            else{
                int[] res = new int[]{start,end};
                al.add(res);
                start = arr[0];
                end = arr[1];
            }
        }
        al.add(new int[]{start,end});
        return al;
    }
}