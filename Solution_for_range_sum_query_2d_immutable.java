public class Solution_for_range_sum_query_2d_immutable {
    class NumMatrix {
        int[][] s;
        public NumMatrix(int[][] matrix) {

            if (matrix.length != 0) {
                s = new int[matrix.length][matrix[0].length];
                s[0][0] = matrix[0][0];
                for (int i = 1; i < matrix.length; i++) {
                    s[i][0] = s[i - 1][0] + matrix[i][0];
                }
                for (int j = 1; j < matrix[0].length; j++) {
                    s[0][j] = s[0][j - 1] + matrix[0][j];
                }
                for (int i = 1; i < matrix.length; i++) {
                    for (int j = 1; j < matrix[0].length; j++) {
                        s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int s2 = 0, s3 = 0, s4 = 0;
            if (col1 - 1 >= 0)
                s2 = s[row2][col1 - 1];
            if (row1 - 1 >= 0)
                s3 = s[row1 - 1][col2];
            if (row1 - 1 >= 0 && col1 - 1 >= 0)
                s4 = s[row1 - 1][col1 - 1];
            return s[row2][col2] - s2 - s3 + s4;
        }
    }
}
