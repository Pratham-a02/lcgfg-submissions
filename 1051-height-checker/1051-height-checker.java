class Solution{
    public int heightChecker(int[] heights){
        int min = 0;
        int max = 0;
        
        for(int height:heights){
            min = Math.min(min,height);
            max = Math.max(max,height);
        }
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int height:heights){
            hm.put(height,hm.getOrDefault(height,0)+1);
        }
        int ans = 0;
        int idx = 0;
        for(int height = min;height<=max;height++){
            if(hm.containsKey(height)){
                int count = hm.get(height);
                
                for(int j = 0;j<count;j++){
                    if(heights[idx++] != height){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}