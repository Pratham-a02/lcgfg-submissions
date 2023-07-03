class Solution {
    public boolean buddyStrings(String a, String b) {
        if(a.length() != b.length()){
            return false;
        }
        
        if(a.equals(b)){
            HashSet<Character> hs = new HashSet<>();
            for(char ch : a.toCharArray()){
                if(hs.contains(ch)){
                    return true;
                }
                hs.add(ch);
            }
            return false;
        }
        else{
            List<Integer> al = new ArrayList<>();
            for(int i = 0;i<a.length();i++){
                if(a.charAt(i) != b.charAt(i)){
                    al.add(i);
                }
            }
            return al.size() == 2 && a.charAt(al.get(0)) == b.charAt(al.get(1)) && a.charAt(al.get(1)) == b.charAt(al.get(0));
        }
    }
}