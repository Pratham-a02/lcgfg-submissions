class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int idx = 0;
        
        while(k >= chalk[idx]){
            k -= chalk[idx];
            idx++;
            if(idx == chalk.length){
                idx = 0;
            }
        }
        return idx;
    }
}