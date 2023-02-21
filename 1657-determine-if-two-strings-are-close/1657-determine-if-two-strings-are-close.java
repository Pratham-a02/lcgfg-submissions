class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        HashSet<Character> hs1 = new HashSet<>();
		HashSet<Character> hs2 = new HashSet<>();
        
        for(int i = 0;i<word1.length();i++){
            hs1.add(word1.charAt(i));
        }
        for(int i = 0;i<word2.length();i++){
            hs2.add(word2.charAt(i));
        }
        if(!hs1.equals(hs2)){
            return false;
        }
        
        List<Integer> al1 = new ArrayList<>();
		List<Integer> al2 = new ArrayList<>();
        
        int[] farr1 = new int[26];
        int[] farr2 = new int[26];
        
        for(int i = 0;i<word1.length();i++){
            char ch = word1.charAt(i);
            
            farr1[ch - 'a']++;
        }
        
        for(int i = 0;i<word2.length();i++){
            char ch = word2.charAt(i);
            
            farr2[ch - 'a']++;
        }
        
        for(int i = 0;i<farr1.length;i++){
            al1.add(farr1[i]);
        }
        for(int i = 0;i<farr2.length;i++){
            al2.add(farr2[i]);
        }
        Collections.sort(al1);
        Collections.sort(al2);
        if(!al1.equals(al2)){
            return false;
        }
        
        
        return true;
    }
}