class Solution {
    public int[][] merge(int[][] intervals){
        List<int[]> al = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->{
            if(a[0]<b[0]){
                return -1;
            }
            else if(a[0] == b[0]){
                return 0;
            }
            else{
                return 1;
            }
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
        return al.toArray(new int[0][]);
    }
}