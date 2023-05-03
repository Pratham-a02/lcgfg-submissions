class Solution{
    public String reverseVowels(String s){
        StringBuilder sb = new StringBuilder(s);
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        hs.add('A');
        hs.add('E');
        hs.add('I');
        hs.add('O');
        hs.add('U');
        int i = 0;
        int j = s.length()-1;
        
        while(i<=j){
            char ch1 = sb.charAt(i);
            char ch2 = sb.charAt(j);
            
            if(hs.contains(ch1) && hs.contains(ch2)){
                sb.setCharAt(i,ch2);
                sb.setCharAt(j,ch1);
                i++;
                j--;
            }
            else if(hs.contains(ch1) && !hs.contains(ch2)){
                j--;
            }
            else if(!hs.contains(ch1) && hs.contains(ch2)){
                i++;
            }
            else if(!hs.contains(ch1) && !hs.contains(ch2)){
                i++;
                j--;
            }
        }
        
        return sb.toString();
    }
}