class Solution {
    public String pushDominoes(String dominoes) {
        dominoes = "L" + dominoes + "R";
        char[] arr = dominoes.toCharArray();
        int pi = 0;
        
        for(int i = 1;i<arr.length;i++){
            if(arr[i] == 'L'){
                if(arr[pi] == 'L'){
                    for(int x = pi+1;x<i;x++){
                        arr[x] = 'L';
                    }
                }
                else if(arr[pi] == 'R'){
                    int li = pi+1;
                    int ri = i-1;
                    
                    while(li<ri){
                        arr[li] = 'R';
                        arr[ri] = 'L';
                        li++;
                        ri--;
                    }
                }
                pi = i;
            }
            else if(arr[i] == 'R'){
                if(arr[pi] == 'L'){
                    
                }
                else if(arr[pi] == 'R'){
                    for(int x = pi+1;x<i;x++){
                        arr[x] = 'R';
                    }
                }
                pi = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<arr.length-1;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}