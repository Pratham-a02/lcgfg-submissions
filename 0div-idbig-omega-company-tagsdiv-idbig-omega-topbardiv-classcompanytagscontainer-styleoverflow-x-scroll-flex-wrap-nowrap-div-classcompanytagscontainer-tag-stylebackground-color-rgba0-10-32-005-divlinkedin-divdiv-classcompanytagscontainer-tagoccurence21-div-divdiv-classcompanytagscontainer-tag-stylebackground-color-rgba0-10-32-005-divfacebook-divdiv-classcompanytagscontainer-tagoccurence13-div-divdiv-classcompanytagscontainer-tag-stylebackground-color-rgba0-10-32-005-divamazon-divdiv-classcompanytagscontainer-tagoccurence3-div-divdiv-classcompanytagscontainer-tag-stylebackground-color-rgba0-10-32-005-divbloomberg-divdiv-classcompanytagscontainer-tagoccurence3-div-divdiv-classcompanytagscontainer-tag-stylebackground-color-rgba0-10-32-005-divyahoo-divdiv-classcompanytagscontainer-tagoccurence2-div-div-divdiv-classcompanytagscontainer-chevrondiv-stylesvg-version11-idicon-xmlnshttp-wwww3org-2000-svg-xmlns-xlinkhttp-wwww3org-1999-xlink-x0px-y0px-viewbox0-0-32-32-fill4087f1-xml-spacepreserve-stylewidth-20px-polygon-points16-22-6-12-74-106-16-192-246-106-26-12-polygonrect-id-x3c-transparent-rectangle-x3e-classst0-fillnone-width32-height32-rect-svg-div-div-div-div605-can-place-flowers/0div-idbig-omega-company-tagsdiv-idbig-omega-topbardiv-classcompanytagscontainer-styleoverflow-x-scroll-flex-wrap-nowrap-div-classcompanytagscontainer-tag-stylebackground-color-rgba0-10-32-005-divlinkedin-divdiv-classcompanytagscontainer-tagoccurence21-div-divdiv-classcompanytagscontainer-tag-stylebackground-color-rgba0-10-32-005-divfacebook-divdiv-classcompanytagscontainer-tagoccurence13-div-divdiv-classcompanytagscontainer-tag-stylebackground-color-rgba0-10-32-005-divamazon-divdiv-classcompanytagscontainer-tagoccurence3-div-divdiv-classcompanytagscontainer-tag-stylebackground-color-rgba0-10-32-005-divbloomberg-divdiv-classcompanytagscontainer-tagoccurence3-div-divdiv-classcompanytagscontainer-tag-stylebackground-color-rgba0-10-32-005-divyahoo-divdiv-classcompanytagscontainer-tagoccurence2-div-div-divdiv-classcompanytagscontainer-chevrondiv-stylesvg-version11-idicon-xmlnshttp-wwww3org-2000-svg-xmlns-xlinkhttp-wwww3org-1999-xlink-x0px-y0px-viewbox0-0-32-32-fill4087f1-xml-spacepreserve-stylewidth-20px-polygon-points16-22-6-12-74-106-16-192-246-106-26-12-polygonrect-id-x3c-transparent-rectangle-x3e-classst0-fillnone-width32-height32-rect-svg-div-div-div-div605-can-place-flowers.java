class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0){
            return true;
        }
        
        for(int i = 0;i<flowerbed.length;i++){
            if(flowerbed[i] == 0){
                boolean left_empty = (i == 0 || flowerbed[i-1] == 0);
                boolean right_empty = (i == flowerbed.length-1 || flowerbed[i+1] == 0);
                
                if(left_empty == true && right_empty == true){
                    n--;
                    flowerbed[i] = 1;
                }
                
                if(n == 0){
                    return true;
                }
            }
        }
        
        return false;
    }
}