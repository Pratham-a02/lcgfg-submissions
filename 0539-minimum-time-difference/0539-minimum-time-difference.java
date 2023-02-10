class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] vis = new boolean[1440];
        for(String str :timePoints){
            String[] t = str.split(":");
            int hour = Integer.parseInt(t[0]);
            int minu = Integer.parseInt(t[1]);
            int total = hour*60 + minu;
            if(vis[total]){
                return 0;
            }
            vis[total] = true;
        }
        
        int min = Integer.MAX_VALUE;
        int first = -1;
        int curr = -1;
        int prev = -1;
        
        for(int i = 0;i<vis.length;i++){
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