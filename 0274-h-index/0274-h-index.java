class Solution{
    public int hIndex(int[] citations){
        int[] farr = new int[citations.length+1];
        
        for(int i = 0;i<citations.length;i++){
            if(citations[i]>=citations.length){
                farr[citations.length]++;
            }
            else{
                farr[citations[i]]++;
            }
        }
        int sum = 0;
        
        for(int i = farr.length-1;i>=0;i--){
            sum += farr[i];
            if(sum>=i){
                return i;
            }
        }
        return 0;
    }
}