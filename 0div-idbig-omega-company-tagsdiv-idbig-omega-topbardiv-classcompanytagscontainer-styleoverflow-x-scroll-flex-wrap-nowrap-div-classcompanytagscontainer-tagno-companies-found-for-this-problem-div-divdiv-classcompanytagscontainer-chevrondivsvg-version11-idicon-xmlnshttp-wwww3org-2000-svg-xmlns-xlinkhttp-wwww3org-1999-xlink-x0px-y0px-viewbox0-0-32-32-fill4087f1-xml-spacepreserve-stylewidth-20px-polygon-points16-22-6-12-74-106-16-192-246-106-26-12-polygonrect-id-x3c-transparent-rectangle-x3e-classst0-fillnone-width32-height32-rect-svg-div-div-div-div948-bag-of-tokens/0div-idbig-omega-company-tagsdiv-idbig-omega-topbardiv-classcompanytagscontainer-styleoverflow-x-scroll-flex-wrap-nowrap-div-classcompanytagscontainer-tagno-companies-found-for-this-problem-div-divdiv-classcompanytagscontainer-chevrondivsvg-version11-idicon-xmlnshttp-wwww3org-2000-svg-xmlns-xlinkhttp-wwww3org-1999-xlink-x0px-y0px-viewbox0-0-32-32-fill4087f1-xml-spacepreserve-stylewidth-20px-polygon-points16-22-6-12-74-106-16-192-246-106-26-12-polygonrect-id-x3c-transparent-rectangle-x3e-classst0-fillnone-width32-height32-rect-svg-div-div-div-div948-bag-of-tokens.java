class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int max = 0;
        int currScore = 0;
        
        int i = 0;
        int j = tokens.length-1;
        
        while(i<=j){
            if(power>=tokens[i]){
                power -= tokens[i];
                currScore++;
                i++;
                max = Math.max(max,currScore);
            }
            else if(currScore>=1){
                currScore--;
                power += tokens[j];
                j--;
                max = Math.max(max,currScore);
            }
            else{
                return max;
            }
        }
        return max;
    }
}