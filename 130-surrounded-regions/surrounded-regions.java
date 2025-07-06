class Solution {
    public void solve(char[][] board) {
       if(board[0].length == 0 || board.length == 0|| board==null){
        return;
       } 

       int m= board.length;
       int n = board[0].length;

       for(int i = 0; i<m; i++){
        if(board[i][0]=='O'){
            Dfs(board, i, 0);
        }
        if(board[i][n-1]=='O'){
            Dfs(board, i, n-1);
        }
       }

        for(int i = 0; i<n; i++){
        if(board[0][i]=='O'){
            Dfs(board, 0, i);
        }
        if(board[m-1][i]=='O'){
            Dfs(board,m-1, i);
        }

       }
       for(int i =0; i<board.length; i++){
        for(int j =0; j<board[0].length; j++){
            if(board[i][j]=='O'){
                board[i][j] = 'X';
            }else if(board[i][j]=='T'){
                board[i][j] = 'O';
            }
        }
       }
    }
    private static void Dfs(char board[][], int i, int j){
        if(i < 0 || j < 0 || j>=board[0].length || i>=board.length || board[i][j] != 'O' ){
            return;
        };
        board[i][j] = 'T';

        Dfs(board , i-1, j);
        Dfs(board , i+1, j);
        Dfs(board , i, j-1);
        Dfs(board , i, j+1);
    }
}