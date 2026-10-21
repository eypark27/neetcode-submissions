class NumMatrix {
    int[][] matrix;
    int[][] prefixSumMatrix;

    private int queryPrefixMatrix(int row, int col) {
        if (row < 0 || col < 0) {
            return 0;
        }

        return prefixSumMatrix[row][col];
    }

    private void populatePrefixMatrix(int row, int col) {
        int value = matrix[row][col];
        value += queryPrefixMatrix(row - 1, col);
        value += queryPrefixMatrix(row, col - 1);
        value -= queryPrefixMatrix(row - 1, col - 1);
        prefixSumMatrix[row][col] = value;
    }

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        this.matrix = matrix;
        this.prefixSumMatrix = new int[m][n];

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                populatePrefixMatrix(y, x);
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int answer = prefixSumMatrix[row2][col2];

        int crust = 0;
        crust += queryPrefixMatrix(row1 - 1, col2);
        crust += queryPrefixMatrix(row2, col1 - 1);
        crust -= queryPrefixMatrix(row1 - 1, col1 - 1);

        return answer - crust;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */