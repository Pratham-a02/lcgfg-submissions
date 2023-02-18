class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> hm = new HashMap<>();
        for(String word : cpdomains){
            word += '.';
            int i = 0;
            int idx = word.indexOf(" ");
            String num = "";
            while(i!=idx){
                num += word.charAt(i);
                i++;
            }
            int val = Integer.parseInt(num);
            String curr = word.substring(idx+1);
            while(curr.length()>0){
                hm.put(curr,hm.getOrDefault(curr,0)+val);
                int j = curr.indexOf('.');
                curr = curr.substring(j+1);
            }
        }
        List<String> ans = new ArrayList<>();
        for(Map.Entry<String,Integer> entry:hm.entrySet()){
            String key = entry.getKey();
            int val = entry.getValue();
            
            String add = val + " " + key;
            add = add.substring(0,add.length()-1);
            ans.add(add);
        }
        return ans;
    }
}