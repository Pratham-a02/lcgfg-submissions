class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<String>();
        for (String w : words)
            if (check(w,pattern)) res.add(w);
        return res;
    }

    private boolean check(String w, String p) {
        if(w.length() != p.length()) return false;
        Map<Character,Character> map1 = new HashMap<>();
        Map<Character,Character> map2 = new HashMap<>();
        for(int i=0; i<w.length(); i++) {
            char c1 = w.charAt(i);
            char c2 = p.charAt(i);
            if(map1.containsKey(c1) && map2.containsKey(c2)) {
                if(map1.get(c1) != c2 || map2.get(c2) != c1) {
                    return false;
                }
            }else if(map1.containsKey(c1)) {
                return false;
            }else if(map2.containsKey(c2)) {
                return false;
            }else {
                map1.put(c1, c2);
                map2.put(c2, c1);
            }
        }
        return true;
    }
}