public class Solution_for_predict_the_winner {
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            dp[i][i] = nums[i];
            sum += nums[i];
        }

        for(int j = 0;j < nums.length;j++){
            for(int i = j-1;i>=0; i--){
                int a = (i+2<nums.length)?dp[i+2][j]:0;
                int b = (i+1<nums.length && j-1>0)?dp[i+1][j-1]:0;
                int c = (i+1<nums.length && j-2>0)?dp[i][j-2]:0;
                dp[i][j] = Math.max(nums[i]+Math.min(a,b),nums[j]+Math.min(b,c));
            }
        }
        return dp[0][nums.length-1]*2>=sum;
    }
}
