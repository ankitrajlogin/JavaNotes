

class Solution{
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int row, int col) {
        // move to next row if we reach end of column
        if (col == 9) {
            col = 0;
            row++;
            if (row == 9) return true; // all filled
        }

        if (board[row][col] != '.') {
            return dfs(board, row, col + 1); // skip filled cell
        }

        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, row, col, c)) {
                board[row][col] = c;
                if (dfs(board, row, col + 1)) return true; // go deeper
                board[row][col] = '.'; // backtrack
            }
        }

        return false; // no valid number -> backtrack
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false; // row
            if (board[i][col] == c) return false; // col
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == c) return false; // box
        }
        return true;
    }
}

public class L03_Sudoku_Solver {
    

    // MAIN for testing
    public static void main(String[] args) {
        Solution solver = new Solution();

        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        solver.solveSudoku(board);

        // print solved sudoku
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

