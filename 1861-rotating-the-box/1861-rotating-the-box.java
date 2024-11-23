class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] ans = new char[n][m];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                ans[j][i] = box[i][j];
            }
        }
        
        
        m = ans.length;
        n = ans[0].length;
        
        // for(int i = 0;i<m;i++){
        //     for(int j = 0;j<n;j++){
        //         System.out.print(ans[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("----------");      
        char[][] res = new char[ans.length][ans[0].length];
        for(char[] arr : res){
            Arrays.fill(arr,'.');
        }
        
        int j = 0;
        while(j<n){
            int cnt = 0;
            int i = 0;
            while(i<m){
                if(ans[i][j] == '#'){
                    cnt++;
                }
                if(ans[i][j] == '*'){
                    res[i][j] = '*';
                    int idx = i-1;
                    while(idx>=0 && cnt>=1 && ans[idx][j] != '*'){
                        res[idx][j] = '#';
                        cnt--;
                        idx--;
                    }
                }
                if(i == m-1){
                    int idx = i;
                    while(idx>=0 && cnt>=1 && ans[idx][j] != '*'){
                        res[idx][j] = '#';
                        cnt--;
                        idx--;
                    }
                }
                i++;
            }
            j++;
        }
        
        int i = 0;
        while(i<res.length){
            char[] arr = res[i];
            int l = 0;
            int r = arr.length-1;
            
            while(l<=r){
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                
                l++;
                r--;
            }
            i++;
        }
        // for(int x = 0;x<res.length;x++){
        //     for(int y = 0;y<res[0].length;y++){
        //         System.out.print(ans[x][y] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("-------------");
        return res;
        
    }
}