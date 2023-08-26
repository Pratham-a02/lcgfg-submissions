class Solution{
    public List<String> fullJustify(String[] words,int maxWidth){
        List<String> ans = new ArrayList<>();
        
        int n = words.length;
        
        int i = 0;
        
        while(i<n){
            int letterCount = words[i].length();
            int j = i+1;
            int gaddhe = 0;
            
            while(j<n && words[j].length()+1+gaddhe+letterCount <= maxWidth){
                letterCount += words[j].length();
                gaddhe++;
                j++;
            }
            
            int remainingGaddhe = maxWidth - letterCount;
            
            int eachGaddhaSpace = (gaddhe == 0)?0:remainingGaddhe/gaddhe;
            int extras = (gaddhe == 0)?0:remainingGaddhe%gaddhe;
            
            if(j == n){
                eachGaddhaSpace = 1;
                extras = 0;
            }
            
            ans.add(findLine(i,j,eachGaddhaSpace,extras,words,maxWidth));
            i = j;
        }
        return ans;
    }
    
    public String findLine(int i,int j,int eachGaddhaSpace,int extras,String[] words,int maxWidth){
        String line = "";
        
        for(int k = i;k<j;k++){
            line += words[k];      
        
            if(k == j-1) continue;
            
            for(int z = 1;z<=eachGaddhaSpace;z++){
                line += " ";
            }

            if(extras>0){
                line += " ";
                extras--;
            }
        }
        
        while(line.length() < maxWidth){
            line += " ";
        }
        
        return line;
    }
}