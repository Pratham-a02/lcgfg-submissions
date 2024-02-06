class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] target = new int[26];
        
        for(String word:words2){
            int[] temp = new int[26];
            
            for(int i = 0;i<word.length();i++){
                char ch = word.charAt(i);
                temp[ch-'a']++;
                target[ch-'a'] = Math.max(target[ch-'a'],temp[ch-'a']);
            }
        }
        
        for(String word:words1){
            int[] temp = new int[26];
            
            for(int i = 0;i<word.length();i++){
                char ch = word.charAt(i);
                temp[ch-'a']++;
            }
            
            if(check(target,temp)){
                ans.add(word);
            }
        }
        return ans;
    }
    
    public boolean check(int[] target,int[] temp){
        for(int i = 0;i<26;i++){
            if(target[i]>temp[i]){
                return false;
            }
        }
        return true;
    }
}