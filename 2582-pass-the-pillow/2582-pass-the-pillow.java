class Solution{
    public int passThePillow(int n,int time){
        int curr = 1;
        
        while (time > 0) {
            // Move forward until the last person
            while (curr < n && time > 0) {
                curr++;
                time--;
            }
            
            // If we are at the last person, move backward
            if (time > 0) {
                while (curr > 1 && time > 0) {
                    curr--;
                    time--;
                }
            }
        }
        
        return curr;
    }
}