class Solution{
    public long dividePlayers(int[] skill){
        if(skill.length == 2){
            return skill[0]*skill[1];
        }
        long sum = 0;
        for(int val:skill){
            sum += val;
        }
        
        Arrays.sort(skill);
        long ans = 0;
        int li = 0;
        int ri = skill.length-1;
        
        while(li<ri){
            if(sum%(skill[li] + skill[ri]) != 0){
                return -1;
            }
            
            ans += (skill[li] * skill[ri]);
            li++;
            ri--;
        }
        
        return ans;
    }
}