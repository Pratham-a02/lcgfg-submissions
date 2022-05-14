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
    public static ArrayList<String> findPath(int[][] grid, int n) {
        ArrayList<String> answer = new ArrayList<>();
        
        generateAllPaths(grid,0,0,n,"",answer);
        
        return answer;
    }
    
    
    private static void generateAllPaths(int[][] grid,int currR,int currC,int n,String currP, ArrayList<String> answer){
        
        if(currR<0 || currC<0 || currR>=n || currC>=n || grid[currR][currC] == 0){
            return;
        }
        
        if(currR == n-1 && currC == n-1){
            answer.add(currP);
            return;
        }
        grid[currR][currC] = 0;
        generateAllPaths(grid,currR-1,currC,n,currP + "U",answer);
        generateAllPaths(grid,currR,currC-1,n,currP+"L",answer);
        generateAllPaths(grid,currR+1,currC,n,currP+"D",answer);
        generateAllPaths(grid,currR,currC+1,n,currP+"R",answer);
        grid[currR][currC] = 1;
        return;
    }
}