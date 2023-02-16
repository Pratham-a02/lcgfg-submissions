class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(String x:sentences){
            String[] y = x.split(" ");
            max = Math.max(max,y.length);
        }
        return max;
    }
}