class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->{
           return a[1]-b[1]; 
        });
        
        int max = 1;
        int curr = pairs[0][1];
        
        for(int i = 1;i<pairs.length;i++){
            if(pairs[i][0]>curr){
                max++;
                curr = pairs[i][1];
            }
        }
        return max;
    }
}