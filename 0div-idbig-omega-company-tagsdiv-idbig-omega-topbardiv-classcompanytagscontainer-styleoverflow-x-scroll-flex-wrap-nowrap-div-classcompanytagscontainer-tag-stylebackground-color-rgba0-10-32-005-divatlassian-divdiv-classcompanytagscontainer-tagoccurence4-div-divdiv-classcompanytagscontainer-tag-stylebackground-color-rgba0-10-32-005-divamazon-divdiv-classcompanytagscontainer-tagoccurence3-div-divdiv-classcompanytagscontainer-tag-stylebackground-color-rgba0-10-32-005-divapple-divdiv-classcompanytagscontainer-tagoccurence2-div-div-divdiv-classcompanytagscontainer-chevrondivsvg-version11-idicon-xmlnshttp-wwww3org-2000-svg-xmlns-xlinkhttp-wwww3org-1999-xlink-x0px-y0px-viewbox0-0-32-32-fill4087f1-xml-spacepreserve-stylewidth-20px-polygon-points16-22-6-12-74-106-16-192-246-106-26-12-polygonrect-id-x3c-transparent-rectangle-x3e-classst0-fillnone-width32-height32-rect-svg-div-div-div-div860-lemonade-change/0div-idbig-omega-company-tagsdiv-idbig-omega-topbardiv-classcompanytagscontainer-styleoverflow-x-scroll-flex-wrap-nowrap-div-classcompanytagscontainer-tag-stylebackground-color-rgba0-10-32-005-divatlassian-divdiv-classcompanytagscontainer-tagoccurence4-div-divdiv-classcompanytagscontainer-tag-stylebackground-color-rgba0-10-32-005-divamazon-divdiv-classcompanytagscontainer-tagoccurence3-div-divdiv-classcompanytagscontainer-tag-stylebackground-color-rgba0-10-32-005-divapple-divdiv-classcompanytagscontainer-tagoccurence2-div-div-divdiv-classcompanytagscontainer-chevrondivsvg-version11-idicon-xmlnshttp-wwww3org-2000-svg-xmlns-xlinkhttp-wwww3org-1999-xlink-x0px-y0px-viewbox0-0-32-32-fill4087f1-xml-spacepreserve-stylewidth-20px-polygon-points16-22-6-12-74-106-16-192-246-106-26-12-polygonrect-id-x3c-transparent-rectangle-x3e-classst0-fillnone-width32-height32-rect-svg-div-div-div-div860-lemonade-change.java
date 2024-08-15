class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0]>5){
            return false;
        }
        int[] arr = new int[3];
        
        for(int val : bills){
            if(val == 5){
                arr[0]++;
            }
            else if(val == 10){
                arr[1]++;
                if(arr[0] > 0){
                    arr[0]--;
                }
                else{
                    return false;
                }
            }
            else{
                arr[2]++;
                if(arr[0]>0 && arr[1]>0){
                    arr[0]--;
                    arr[1]--;
                }
                else if(arr[0]*5 >= 15){
                    arr[0] -= 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}