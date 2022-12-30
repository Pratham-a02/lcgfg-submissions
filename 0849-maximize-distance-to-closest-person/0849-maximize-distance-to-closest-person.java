class Solution {
    public int maxDistToClosest(int[] seats) {
        int last = -1;
        int res = 0;
        for(int i = 0;i<seats.length;i++){
            if(seats[i] == 1){
                res = last<0?i:Math.max(res,(i-last)/2);
                last = i;
            }
        }
        
        res = Math.max(res,seats.length-last-1);
        return res;
    }
}