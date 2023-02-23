class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] target = new int[26];
        List<String> ans = new ArrayList<>();
        for(String word:words2){
            int[] temp = new int[26];
            
            for(int i = 0;i<word.length();i++){
                char ch = word.charAt(i);
                temp[ch-'a']++;
            }
            
            for(int i = 0;i<26;i++){
                target[i] = Math.max(target[i],temp[i]);
            }
        }
        
        for(String word:words1){
            int[] temp = new int[26];
            for(int i = 0;i<word.length();i++){
                char ch = word.charAt(i);
                temp[ch-'a']++;
            }
            
            if(isPossible(target,temp)){
                ans.add(word);
            }
        }
        return ans;
    }
    
    public boolean isPossible(int[] target,int[] temp){
        for(int i = 0;i<26;i++){
            if(target[i]>temp[i]){
                return false;
            }
        }
        return true;
    }
}