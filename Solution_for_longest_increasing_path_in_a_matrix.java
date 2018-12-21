public class Solution_for_longest_increasing_path_in_a_matrix {
    private int m, n;
    private int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || (m = matrix.length) == 0 || (n = matrix[0].length) == 0) {
            return 0;
        }
        int best = 0;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                best = Math.max(best, helper(matrix, dp, i, j));
            }
        }
        return best;
    }

    private int helper(int[][] matrix, int[][] dp, int i, int j) {
        if(dp[i][j] > 0) {
            return dp[i][j];
        }
        dp[i][j] = 1;
        for(int[] d : direction) {
            int x = i + d[0];
            int y = j + d[1];
            if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                int dis = helper(matrix, dp, x, y) + 1;
                dp[i][j] = Math.max(dp[i][j], dis);
            }
        }
        return dp[i][j];
    }
}
