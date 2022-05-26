// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        generatePath(m,n,0,0,"",ans);
        return ans;
    }
    
    public static void generatePath(int[][] m,int n,int r, int c,String path,ArrayList<String> ans){
        if(r<0 || c<0 || r>=n || c>=n || m[r][c] == 0){
            return;
        }
        if(r == n-1 && c == n-1){
            ans.add(path);
            return;
        }
        m[r][c] = 0;
        generatePath(m,n,r-1,c,path+"U",ans);
        generatePath(m,n,r,c-1,path+"L",ans);
        generatePath(m,n,r+1,c,path+"D",ans);
        generatePath(m,n,r,c+1,path+"R",ans);
        m[r][c] = 1;
        return;
    }
}