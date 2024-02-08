class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] vis = new boolean[1440];
        
        for(String s:timePoints){
            String[] arr = s.split(":");
            int hr = Integer.parseInt(arr[0]);
            int min = Integer.parseInt(arr[1]);
            int val = (hr*60)+min;
            if(vis[val]){
                return 0;
            }
            vis[val] = true;
        }
        
        int curr = -1;
        int first = -1;
        int prev = -1;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0;i<1440;i++){
            if(vis[i]){
                if(first == -1){
                    first = i;
                    prev = i;
                }
                else{
                    curr = i;
                    min = Math.min(min,curr-prev);
                    prev = curr;
                }
            }
        }
        
        return Math.min(min,1440-curr+first);
    }
}