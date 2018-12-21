import java.util.PriorityQueue;

public class Solution_for_trapping_rain_water_ii {
    public int trapRainWater(int[][] heightMap) {
        class Cell{
            int x,y,h;
            Cell(int x ,int y ,int h){
                this.h = h;
                this.x = x;
                this.y = y;
            }
        }
        if(heightMap.length == 0 || heightMap == null || heightMap[0].length == 0){
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Cell> quene = new PriorityQueue<Cell>((v1,v2)->v1.h - v2.h);
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < n; i++){
            visited[0][i] = true;
            visited[m-1][i] = true;
            quene.offer(new Cell(0, i, heightMap[0][i]));
            quene.offer(new Cell(m-1, i, heightMap[m-1][i]));
        }
        for(int i = 1; i < m-1; i++){
            visited[i][0] = true;
            visited[i][n-1] = true;
            quene.offer(new Cell(i, 0, heightMap[i][0]));
            quene.offer(new Cell(i, n-1, heightMap[i][n-1]));
        }
        int[] xs = {0,  0, 1, -1};
        int[] ys = {1, -1, 0,  0};
        int sum = 0;
        while (!quene.isEmpty()) {
            Cell cell = quene.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cell.x + xs[i];
                int ny = cell.y + ys[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    sum += Math.max(0, cell.h - heightMap[nx][ny]);
                    quene.offer(new Cell(nx, ny, Math.max(heightMap[nx][ny], cell.h)));
                }
            }
        }
        return sum;
    }
}
