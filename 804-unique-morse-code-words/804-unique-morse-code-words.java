class Solution {
    public int uniqueMorseRepresentations(String[] words){
        HashMap<Character,String> hm = new HashMap<>();
        hm.put('a',".-");
        hm.put('b',"-...");
        hm.put('c',"-.-.");
        hm.put('d',"-..");
        hm.put('e',".");
        hm.put('f',"..-.");
        hm.put('g',"--.");
        hm.put('h',"....");
        hm.put('i',"..");
        hm.put('j',".---");
        hm.put('k',"-.-");
        hm.put('l',".-..");
        hm.put('m',"--");
        hm.put('n',"-.");
        hm.put('o',"---");
        hm.put('p',".--.");
        hm.put('q',"--.-");
        hm.put('r',".-.");
        hm.put('s',"...");
        hm.put('t',"-");
        hm.put('u',"..-");
        hm.put('v',"...-");
        hm.put('w',".--");
        hm.put('x',"-..-");
        hm.put('y',"-.--");
        hm.put('z',"--..");



        HashSet<String> hs = new HashSet<>();
        
        if(words.length == 1){
            return 1;
        }
    
        for(int i = 0;i<words.length;i++){
            String wor = words[i];
            String s = "";
            for(int j = 0;j<wor.length();j++){
                s = s.concat(hm.get(wor.charAt(j)));
            }
            hs.add(s);
        }
        return hs.size();
    }
}