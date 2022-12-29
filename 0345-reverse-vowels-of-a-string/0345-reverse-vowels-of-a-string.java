class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        List<Character> al = new ArrayList<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == 'a'|| s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A'|| s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U'){
                al.add(s.charAt(i));
            }
        }
        
        int idx = al.size()-1;
        for(int i = 0;i<sb.length();i++){
            if(sb.charAt(i) == 'a'|| sb.charAt(i) == 'e' || sb.charAt(i) == 'i' || sb.charAt(i) == 'o' || sb.charAt(i) == 'u' || sb.charAt(i) == 'A'|| sb.charAt(i) == 'E' || sb.charAt(i) == 'I' || sb.charAt(i) == 'O' || sb.charAt(i) == 'U'){
                sb.setCharAt(i,al.get(idx));
                idx--;
            }
                
        }
        return sb.toString();
    }
}