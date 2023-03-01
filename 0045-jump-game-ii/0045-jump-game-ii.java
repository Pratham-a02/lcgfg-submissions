class Solution {
    public int jump(int[] arr) {
        int n = arr.length;
        if (n <= 1)
           return 0;
 
        // if (arr[0] == 0)
        //     return -1;
     
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;
     
        int i = 1;
        for (i = 1; i < n; i++) {
            if (i == n - 1)
                return jump;
    
            maxReach = Math.max(maxReach, i + arr[i]);
            step--;
            if (step == 0) {
                jump++;
                step = maxReach - i;
            }
        }
     
        return -1;

    }
}