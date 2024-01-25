class Solution{
    public int maxScoreSightseeingPair(int[] values){
        int max = Integer.MIN_VALUE;
        int n = values.length;
        int[] maxfl = new int[n];
        int[] minfl = new int[n];
        maxfl[0] = minfl[0] = values[0];
        
        for(int i = 1;i<n;i++){
            maxfl[i] = Math.max(maxfl[i-1],values[i]+i);
            minfl[i] = (values[i] - i);
        }
        
        for(int i = 1;i<n;i++){
            max = Math.max(max,minfl[i]+maxfl[i-1]);
        }
        return max;
    }
}