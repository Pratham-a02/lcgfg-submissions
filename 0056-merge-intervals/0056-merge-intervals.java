class Solution {
    public int[][] merge(int[][] intervals) {
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
        List<int[]> ans = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int[] arr:intervals){
            if(arr[0]<=end){
                end = Math.max(end,arr[1]);
            }
            else{
                int[] ar = new int[]{start,end};
                ans.add(ar);
                start = arr[0];
                end = arr[1];
            }
        }
        
        ans.add(new int[]{start,end});
        return ans.toArray(new int[0][]);
    }
}