class Solution{
    public List<String> commonChars(String[] words){
        List<String> ans = new ArrayList<>();
        int[] common = new int[26];
        for(int i = 0;i<common.length;i++){
            common[i] = Integer.MAX_VALUE;
        }
        
        for(String word : words){
            int[] cnt = new int[26];
            
            for(char ch:word.toCharArray()){
                cnt[ch-'a']++;
            }
            for(int i = 0;i<26;i++){
                common[i] = Math.min(common[i],cnt[i]);
            }
        }
        
        for(int i = 0;i<26;i++){
            int freq = common[i];
            for(int j = 0;j<freq;j++){
                String curr = (char)(i+'a') + "";
                ans.add(curr);
            }
        }
        return ans;
    }
}