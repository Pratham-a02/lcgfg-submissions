class Solution{
    public int maxVowels(String s,int k){
        HashSet<Character> hs = new HashSet<>();
        
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        
        int left = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        
        for(int right = 0;right<s.length();right++){
            if(hs.contains(s.charAt(right))){
                count++;
            }
            
            while(right-left+1 > k){
                if(hs.contains(s.charAt(left))){
                    count--;
                }
                left++;
            }
            
            if(right-left+1 == k){
                max = Math.max(max,count);
            }
        }
        
        return max;
    }
}