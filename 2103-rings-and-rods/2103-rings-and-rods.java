class Solution {
    public int countPoints(String rings) {
        Map<Character, Set<Character>> map = new HashMap();
        for(int i = 0; i< rings.length(); i=i+2){
            char color = rings.charAt(i);
            char rod = rings.charAt(i+1);
            Set<Character> set=map.getOrDefault(rod, new HashSet<>());
            set.add(color);
            map.put(rod,set);
        }
        int result = 0;
        for(Set<Character> set: map.values())
            if (set.size()==3)
                result++;
        return result;
    }
}