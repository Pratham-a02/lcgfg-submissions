class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int poc = 0;
        for(int i = 0;i<bank.length;i++){
            String word = bank[i];
            int coc = 0;
            for(int j = 0;j<word.length();j++){
                if(word.charAt(j) == '1'){
                    coc++;
                }   
            }
            if(coc>0){
                ans += poc*coc;
                poc = coc;
            }
        }
        
        return ans;
    }
}