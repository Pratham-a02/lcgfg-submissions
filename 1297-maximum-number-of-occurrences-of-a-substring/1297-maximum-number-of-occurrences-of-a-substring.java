class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize){
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        int left = 0;
        int max = 0;
        for(int right = 0;right<s.length();right++){
            char ch = s.charAt(right);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
            
            
            while(map1.size() > maxLetters || (right-left+1)>maxSize){
                char disChar = s.charAt(left);

                map1.put(disChar,map1.get(disChar)-1);
                if(map1.get(disChar) == 0){
                    map1.remove(disChar);
                }
                left++;
            }
            
            // if((right-left+1) == maxSize){
            //     while((right-left+1)>=minSize){
            //         char disChar = s.charAt(left);
            //         map1.put(disChar,map1.get(disChar)-1);
            //         if(map1.get(disChar) == 0){
            //             map1.remove(disChar);
            //         }
            //         left++;
            //     }
            // }
            
            
            while(map1.size() <= maxLetters && (right-left+1)>=minSize && (right-left+1)<=maxSize){
                map2.put(s.substring(left,right+1),map2.getOrDefault(s.substring(left,right+1),0)+1);
                max = Math.max(max, map2.get(s.substring(left,right+1)));
                char leftChar = s.charAt(left);
                map1.put(leftChar, map1.get(leftChar) - 1);
                if(map1.get(leftChar) == 0) {
                    map1.remove(leftChar);
                }
                left++;
            }
        
          
    
  }
        return max;
}
}