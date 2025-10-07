class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean vis[][] = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
               if(wordExist(board, word, 0, i,j, n, m, vis)){
                 return true;
               }
            }
        }
    return false;
    }

    private static boolean wordExist(char board[][], String word,int i , int row, int col, int n, int m, boolean vis[][]){
        if(i== word.length()){
            return true;
        }
        // base case
        char ch = word.charAt(i);
        if(row <0|| col < 0 || row>=n || col >=m || board[row][col]!= ch || vis[row][col]){
            return false;
        }
        
        //work
        vis[row][col] = true;
        boolean fund =  wordExist(board, word, i+1, row+1 ,col , n, m, vis)||wordExist(board, word, i+1, row ,col+1 , n, m, vis) ||wordExist(board, word, i+1, row-1 , col, n, m, vis) || wordExist(board, word, i+1, row ,col-1 , n, m, vis);

        vis[row][col] = false;
        return fund;
    
    }
}