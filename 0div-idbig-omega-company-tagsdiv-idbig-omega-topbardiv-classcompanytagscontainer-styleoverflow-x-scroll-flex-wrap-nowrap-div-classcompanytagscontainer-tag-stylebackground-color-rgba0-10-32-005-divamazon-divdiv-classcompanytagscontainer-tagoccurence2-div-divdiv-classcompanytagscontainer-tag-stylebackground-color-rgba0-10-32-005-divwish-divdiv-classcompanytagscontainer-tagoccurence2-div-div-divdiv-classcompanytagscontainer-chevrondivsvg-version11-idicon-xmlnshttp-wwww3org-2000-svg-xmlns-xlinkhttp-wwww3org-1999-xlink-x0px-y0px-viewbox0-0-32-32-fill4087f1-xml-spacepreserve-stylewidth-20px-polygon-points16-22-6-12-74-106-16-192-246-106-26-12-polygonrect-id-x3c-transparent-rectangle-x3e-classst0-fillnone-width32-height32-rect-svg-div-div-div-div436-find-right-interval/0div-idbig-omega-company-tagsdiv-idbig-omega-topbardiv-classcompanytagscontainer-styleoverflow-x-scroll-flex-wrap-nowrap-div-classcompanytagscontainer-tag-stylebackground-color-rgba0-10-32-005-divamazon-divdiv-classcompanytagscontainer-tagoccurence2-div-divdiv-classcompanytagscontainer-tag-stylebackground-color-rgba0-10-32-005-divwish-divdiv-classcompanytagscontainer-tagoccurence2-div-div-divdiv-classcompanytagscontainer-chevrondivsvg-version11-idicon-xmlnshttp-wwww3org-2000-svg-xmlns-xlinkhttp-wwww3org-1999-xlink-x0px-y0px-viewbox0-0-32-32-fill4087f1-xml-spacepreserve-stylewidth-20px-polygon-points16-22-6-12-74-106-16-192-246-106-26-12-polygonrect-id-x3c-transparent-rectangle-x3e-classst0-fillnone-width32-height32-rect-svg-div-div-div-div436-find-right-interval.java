class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        if(n == 1 && intervals[0][0] == intervals[0][1]){
            return new int[]{0};
        }
        if(n == 1){
            return new int[]{-1};
        }
        
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        
        for(int i = 0;i<n;i++){
            hm.put(intervals[i][0],i);
        }
        
        int[] ans = new int[n];
        
        for(int i = 0;i<n;i++){
            
            int val = intervals[i][1];
            
            Integer ceilValue = hm.ceilingKey(val);
            
            if(ceilValue == null){
                ans[i] = -1;
            }
            else{
                ans[i] = hm.get(ceilValue);
            }
        }
        return ans;
    }
}