package JavaCode;

public class Java304 {
    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
    class NumMatrix {
        public int[][] matrix;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int row = row2 - row1 + 1;
            int column = col2 - col1 + 1;
            int res = 0;
            for (int i = row1; i < row1 + row; i++) {
                for (int j = col1; j < col1 + column; j++) {
                    res += matrix[i][j];
                }
            }
            return res;
        }
    }


}
