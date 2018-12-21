import java.util.HashSet;
import java.util.Set;

public class Solution_for_largest_plus_sign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] dp = new int[N][N];
        Set<Integer> mineset = new HashSet<Integer>();
        for(int[] mine:mines){
            mineset.add(mine[0]*N + mine[1]);//学到了有点秀
        }
        int ans = 0;
        for(int i = 0;i < N ;i++){
            int count = 0;
            for(int j = 0;j <N ;j++){
                count = mineset.contains(i * N + j)?0:count+1;
                dp[i][j] = count;
            }
            count = 0;
            for(int j = N-1;j>=0;j--){
                count = mineset.contains(i * N + j)?0:count+1;
                dp[i][j] = Math.min(dp[i][j],count);
            }
        }
        for(int j = 0;j < N ;j++){
            int count = 0;
            for(int i = 0;i <N ;i++){
                count = mineset.contains(i * N + j)?0:count+1;
                dp[i][j] = Math.min(dp[i][j],count);
            }
            count = 0;
            for(int i = N-1;i>=0;i--){
                count = mineset.contains(i * N + j)?0:count+1;
                dp[i][j] = Math.min(dp[i][j],count);
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}
