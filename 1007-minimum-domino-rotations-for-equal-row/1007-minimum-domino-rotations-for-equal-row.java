class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int firstEligible = tops[0];
        int secEligible = bottoms[0];
        
        for(int i = 1;i<tops.length;i++){
            if(tops[i] != firstEligible && bottoms[i] != firstEligible){
                firstEligible = -1;
            }
            
            if(tops[i] != secEligible && bottoms[i] != secEligible){
                secEligible = -1;
            }
            
            if(firstEligible == -1 && secEligible == -1){
                return -1;
            }
        }
        
        int eligibleDom = (firstEligible == -1)?secEligible:firstEligible;
        int topSwap = 0;
        int bottomSwap = 0;
        
        for(int i = 0;i<tops.length;i++){
            if(tops[i] != eligibleDom) topSwap++;
            if(bottoms[i] != eligibleDom) bottomSwap++;
        }
        return Math.min(topSwap,bottomSwap);
    }
}