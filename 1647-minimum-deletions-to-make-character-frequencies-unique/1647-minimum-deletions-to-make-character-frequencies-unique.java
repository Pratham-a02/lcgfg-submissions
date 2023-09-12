class Solution{
    public int minDeletions(String s){
        int[] farr = new int[26];
        
        for(char ch:s.toCharArray()){
            farr[ch-'a']++;
        }
        
        HashSet<Integer> hs = new HashSet<>();
        int deletions = 0;
        
        for(int count:farr){
            while(count>0 && hs.contains(count)){
                count--;
                deletions++;
            }
            hs.add(count);
        }
        return deletions;
    }
}