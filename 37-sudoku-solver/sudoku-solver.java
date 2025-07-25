class Solution {
    public static boolean isSafe(char mat[][], int row, int col, int digit) {
        char d = (char)(digit + '0');

        // check column
        for (int i = 0; i < 9; i++) {
            if (mat[i][col] == d) return false;
        }

        // check row
        for (int i = 0; i < 9; i++) {
            if (mat[row][i] == d) return false;
        }

        // check 3x3 box
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (mat[i][j] == d) return false;
            }
        }

        return true;
    }

    public static boolean sudokuSolver(char mat[][], int row, int col) {
        // base case: if row is 9, puzzle is solved
        if (row == 9) return true;

        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (mat[row][col] != '.') {
            return sudokuSolver(mat, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(mat, row, col, digit)) {
                mat[row][col] = (char)(digit + '0');

                if (sudokuSolver(mat, nextRow, nextCol)) {
                    return true;
                }

                // backtrack
                mat[row][col] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        sudokuSolver(board, 0, 0);
    }
}
