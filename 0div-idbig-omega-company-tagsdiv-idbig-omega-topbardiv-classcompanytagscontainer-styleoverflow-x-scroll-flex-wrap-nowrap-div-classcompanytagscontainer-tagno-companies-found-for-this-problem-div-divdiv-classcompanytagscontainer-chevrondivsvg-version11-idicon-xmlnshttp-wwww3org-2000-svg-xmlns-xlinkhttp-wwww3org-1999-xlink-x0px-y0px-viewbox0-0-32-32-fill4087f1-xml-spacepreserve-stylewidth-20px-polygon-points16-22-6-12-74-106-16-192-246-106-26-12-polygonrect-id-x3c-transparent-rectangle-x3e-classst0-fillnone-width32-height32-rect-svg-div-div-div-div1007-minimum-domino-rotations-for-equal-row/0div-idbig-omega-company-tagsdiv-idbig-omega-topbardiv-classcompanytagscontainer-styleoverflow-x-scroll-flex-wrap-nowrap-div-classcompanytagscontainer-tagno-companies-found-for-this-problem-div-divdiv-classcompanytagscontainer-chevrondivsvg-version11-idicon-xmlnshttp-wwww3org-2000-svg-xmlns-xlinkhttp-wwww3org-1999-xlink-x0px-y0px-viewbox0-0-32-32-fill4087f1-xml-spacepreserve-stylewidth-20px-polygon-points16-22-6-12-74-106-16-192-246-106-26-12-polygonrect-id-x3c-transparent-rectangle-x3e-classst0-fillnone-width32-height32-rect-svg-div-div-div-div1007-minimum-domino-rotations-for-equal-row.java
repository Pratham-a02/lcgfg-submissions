class Solution{
    public int minDominoRotations(int[] tops,int[] bottoms){
        int fe = tops[0];
        int se = bottoms[0];
        
        for(int i = 1;i<tops.length;i++){
            if(tops[i] != fe && bottoms[i] != fe){
                fe = -1;
            }
            
            if(tops[i] != se && bottoms[i] != se){
                se = -1;
            }
            
            if(fe == -1 && se == -1){
                return -1;
            }
        }
        
        int eligible = (fe == -1)?se:fe;
        
        int ts = 0;
        int bs = 0;
        for(int i = 0;i<tops.length;i++){
            if(tops[i] != eligible) ts++;
            if(bottoms[i] != eligible) bs++;
        }
        
        return Math.min(ts,bs);
    }
}