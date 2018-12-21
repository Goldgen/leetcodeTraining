
import java.util.LinkedList;
import java.util.Queue;

public class Solution_for_surrounded_regions {
    private int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int j=0; j<n; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = 'M';
                queue.offer(new int[]{0, j});
            }
            if (board[m-1][j] == 'O') {
                board[m-1][j] = 'M';
                queue.offer(new int[]{m-1, j});
            }
        }
        for (int i=1; i<m-1; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'M';
                queue.offer(new int[]{i, 0});
            }
            if (board[i][n-1] == 'O') {
                board[i][n-1] = 'M';
                queue.offer(new int[]{i, n-1});
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            for (int[] dir : dirs) {
                int ni = i+dir[0];
                int nj = j+dir[1];
                if (!(ni>0 && ni<m && nj>0 && nj<n) || board[ni][nj] == 'X' || board[ni][nj] == 'M') {
                    continue;
                }
                else {
                    board[ni][nj] = 'M';
                    queue.offer(new int[]{ni, nj});
                }
            }
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'O' ) {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'M' ) {
                    board[i][j] = 'O';
                }
            }
        }

    }
}
