class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int pc = 0;
        int mc = 0;
        int gc = 0;
        
        for(int i = 0;i<garbage.length;i++){
            String word = garbage[i];
            for(int j = 0;j<word.length();j++){
                char ch = word.charAt(j);
                if(ch == 'P'){
                    pc++;
                }
                else if(ch == 'G'){
                    gc++;
                }
                else if(ch == 'M'){
                    mc++;
                }
            }
        }
        
        int pc1 = 0;
        int gc1 = 0;
        int mc1 = 0;
        int count = 0;
        for(int i = 0;i<garbage.length;i++){
            String word = garbage[i];

            for(int j = 0;j<word.length();j++){
                if(word.charAt(j) == 'P'){
                    pc1++;
                }
            }
            
            if(pc1 == pc){
                break;
            }
            if(i<travel.length){
                count += travel[i];
            }
        }
        pc1+=count;
        count = 0;
        for(int i = 0;i<garbage.length;i++){
            String word = garbage[i];

            for(int j = 0;j<word.length();j++){
                if(word.charAt(j) == 'G'){
                    gc1++;
                }
            }
            
            if(gc1 == gc){
                break;
            }
            if(i<travel.length){
                count += travel[i];
            }
        }
        gc1+=count;
        count = 0;
        
        for(int i = 0;i<garbage.length;i++){
            String word = garbage[i];

            for(int j = 0;j<word.length();j++){
                if(word.charAt(j) == 'M'){
                    mc1++;
                }
            }
            
            if(mc1 == mc){
                break;
            }
            if(i<travel.length){
                count += travel[i];
            }
        }
        mc1+=count;
        return (pc1+gc1+mc1);
    }
}