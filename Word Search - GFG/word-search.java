//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution{
    public boolean isWordExist(char[][] board, String word){
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0) && dfs(i,j,0,board,word)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int i,int j,int count,char[][] board,String word){
        if(count == word.length()){
            return true;
        }
        
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != word.charAt(count)){
            return false;
        }
        
        char temp = board[i][j];
        board[i][j] = '*';
        
        boolean found = (dfs(i+1,j,count+1,board,word) || dfs(i-1,j,count+1,board,word) || dfs(i,j+1,count+1,board,word) || dfs(i,j-1,count+1,board,word));
        
        board[i][j] = temp;
        return found;
    }
}