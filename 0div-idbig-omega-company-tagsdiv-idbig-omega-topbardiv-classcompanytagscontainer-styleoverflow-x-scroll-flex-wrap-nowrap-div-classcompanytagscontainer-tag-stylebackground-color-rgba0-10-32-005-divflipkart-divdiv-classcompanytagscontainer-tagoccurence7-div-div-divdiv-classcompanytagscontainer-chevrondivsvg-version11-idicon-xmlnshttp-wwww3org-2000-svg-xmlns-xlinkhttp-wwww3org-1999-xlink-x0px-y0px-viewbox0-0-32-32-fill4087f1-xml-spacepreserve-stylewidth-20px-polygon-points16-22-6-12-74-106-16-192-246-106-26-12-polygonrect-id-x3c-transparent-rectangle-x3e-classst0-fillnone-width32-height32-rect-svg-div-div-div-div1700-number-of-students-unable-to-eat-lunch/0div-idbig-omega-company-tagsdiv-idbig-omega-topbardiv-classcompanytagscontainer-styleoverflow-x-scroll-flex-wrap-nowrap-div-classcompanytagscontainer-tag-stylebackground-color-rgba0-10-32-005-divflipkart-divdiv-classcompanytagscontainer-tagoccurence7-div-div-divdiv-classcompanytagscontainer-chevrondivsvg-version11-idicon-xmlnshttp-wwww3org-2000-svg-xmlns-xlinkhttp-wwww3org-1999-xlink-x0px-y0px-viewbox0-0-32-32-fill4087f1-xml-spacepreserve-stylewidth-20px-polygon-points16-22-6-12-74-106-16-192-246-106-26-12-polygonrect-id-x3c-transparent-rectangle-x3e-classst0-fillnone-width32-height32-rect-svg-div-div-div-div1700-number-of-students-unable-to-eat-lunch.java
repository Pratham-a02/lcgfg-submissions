class Solution{
    public int countStudents(int[] students, int[] sandwiches){
        int oc = 0;
        int zc = 0;
        
        for(int val:students){
            if(val == 1){
                oc++;
            }
            else{
                zc++;
            }
        }

        for(int i = 0;i<sandwiches.length;i++){
            if(sandwiches[i] == 1 & oc == 0){
                return zc;
            }
            else if(sandwiches[i] == 0 && zc == 0){
                return oc;
            }
            else if(sandwiches[i] == 0){
                zc--;
            }
            else{
                oc--;
            }
        }
        return 0;
    }
}