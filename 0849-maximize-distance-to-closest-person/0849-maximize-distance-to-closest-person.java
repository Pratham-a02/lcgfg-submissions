class Solution {
    public int maxDistToClosest(int[] seats) {
        int j = -1;
        int res = 0;
        
        for(int i = 0;i<seats.length;i++){
            if(seats[i] == 1){
                if(j<0){
                    res = i;
                }
                else{
                    res = Math.max(res,(i-j)/2);
                }
                j = i;
            }
        }
        
        res = Math.max(res,seats.length-j-1);
        return res;
    }
}