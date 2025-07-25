class Solution {
    // Function to check if placing a Queen is safe
    public static boolean isSafe(char[][] board, int row, int col){
        // Check same column upwards
       for(int i=row-1; i>=0; i--){ //no need to move colum
        if(board[i][col]=='Q') return false;
       }

        // Check upper left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j]=='Q') return false;
        }

        // ✅ Correct: check upper **right** diagonal
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j]=='Q') return false;
        }
        

        return true;
    }

    // Backtracking function
    public static int QueenSolver(char[][] board, int row) {
        if (row == board.length) {
            // Optional: printqueen(board);
             printqueen(board);
            return 1; // Found a valid solution
        }

        int count = 0;

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q'; // Place queen
                count += QueenSolver(board, row + 1); // Move to next row
                board[row][col] = '.'; // Backtrack
            }
        }

        return count;
    }

    // Helper to print board (optional)
    public static void printqueen(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main entry point
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        return QueenSolver(board, 0);
    }
}
