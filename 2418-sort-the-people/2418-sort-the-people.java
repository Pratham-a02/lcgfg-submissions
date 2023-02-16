class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer,String> hm = new TreeMap<>();
        for(int i = 0;i<names.length;i++){
            hm.put(heights[i],names[i]);
        }
        
        List<String> al = new ArrayList<>();
        for(String val:hm.values()){
            al.add(val);
        }
        
        Collections.reverse(al);
        String[] ans = new String[al.size()];
        int i = 0;
        for(String val:al){
            ans[i++] = val;
        }
        return ans;
    }
}