class Solution {
    public int uniqueLetterString(String s) {
        HashMap<Character,List<Integer>> hm = new HashMap<>();
        int ans = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(hm.containsKey(ch)){
                List<Integer> al = hm.get(ch);
                al.add(i);
            }
            else{
                List<Integer> al = new ArrayList<>();
                al.add(i);
                hm.put(ch,al);
            }
        }
        for(char ch:s.toCharArray()){
            if(hm.containsKey(ch)){
                List<Integer> al = hm.get(ch);
                if(al.get(0) != -1){
                    al.add(0,-1);
                    al.add(al.size(),s.length());
                }
            }
        }
        
        for(List<Integer> al:hm.values()){
            for(int i = 1;i<al.size()-1;i++){
                ans += ((al.get(i)-al.get(i-1)) * (al.get(i+1)-al.get(i)));
            }
        }
        
        return ans;
    }
}