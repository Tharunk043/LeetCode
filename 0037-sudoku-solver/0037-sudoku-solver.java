class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }
    
    private boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) { // try all digits
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; // place the number
                            if (backtrack(board)) {
                                return true; // solution found
                            } else {
                                board[i][j] = '.'; // backtrack
                            }
                        }
                    }
                    return false; // no valid number found
                }
            }
        }
        return true; // all cells filled
    }
    
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // check row
            if (board[row][i] == c) return false;
            // check column
            if (board[i][col] == c) return false;
            // check 3x3 subgrid
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == c) return false;
        }
        return true;
    }
}
