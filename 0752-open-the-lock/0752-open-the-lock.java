class Pair{
    String s;
    int level;
    
    Pair(String s,int level){
        this.s = s;
        this.level = level;
    }
}

class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> hs = new HashSet<>();
        for(String str:deadends){
            hs.add(str);
        }
        if(hs.contains("0000")){
            return -1;
        }
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        qu.add(new Pair("0000",0));
        HashSet<String> vis = new HashSet<>();
        vis.add("0000");
        
        while(qu.size()>0){
            Pair rem = qu.remove();
            if(rem.s.equals(target)){
                return rem.level;
            }
            
            for(int i = 0;i<4;i++){
                StringBuilder sb = new StringBuilder(rem.s);
                int val = sb.charAt(i) - '0';
                int ch = (val+1)%10;
                sb.setCharAt(i,(char)(ch+'0'));
                if(!vis.contains(sb + "") && ! hs.contains(sb + "")){
                    qu.add(new Pair(sb + "",rem.level+1));
                    vis.add(sb + "");
                    
                }
                
                ch = (val == 0)?9:(val-1);
                sb.setCharAt(i,(char)(ch+'0'));
                if(!vis.contains(sb + "") && ! hs.contains(sb + "")){
                    qu.add(new Pair(sb + "",rem.level+1));
                    vis.add(sb + "");
                }
            }
        }
        
        return -1;
    }
}