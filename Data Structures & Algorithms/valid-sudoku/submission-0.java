class Solution {
    private boolean rowValid(char[][] board, int row) {
        Set<Character> numSet = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            char c = board[row][i];

            if (c != '.' && numSet.contains(c)) {
                return false;
            }

            numSet.add(c);
        }

        return true;
    }

    private boolean colValid(char[][] board, int col) {
        Set<Character> numSet = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            char c = board[i][col];

            if (c != '.' && numSet.contains(c)) {
                return false;
            }

            numSet.add(c);
        }

        return true;
    }

    private boolean boxValid(char[][] board, int num) {
        Set<Character> numSet = new HashSet<>();
        int row = 3 * (num / 3);
        int col = 3 * (num % 3);

        for (int y = row; y < row + 3; y++) {

            for (int x = col; x < col + 3; x++) {
                char c = board[y][x];

                if (c != '.' && numSet.contains(c)) {
                    return false;
                }

                numSet.add(c);
            }
        }

        return true;
    }      

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean rowValid = rowValid(board, i);
            boolean colValid = colValid(board, i);
            boolean boxValid = boxValid(board, i);

            if (!rowValid || !colValid || !boxValid) {
                return false;
            }
        }

        return true;
    }
}
