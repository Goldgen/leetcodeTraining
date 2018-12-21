import java.util.List;

public class Solution_for_triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int i = triangle.size()-1;i>=0;i--){
            for(int j = 0;j<=i;j++){
                if(i == triangle.size()-1){
                    dp[i][j] = triangle.get(i).get(j);
                }
                else {
                    dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args){
//        boolean a = true;
//        boolean b = true;
//        int y = 0;
//        if(y){
//            System.out.print("sssss");
//        }
        //String a = String.valueOf(null);
    String a = "aaa";
    System.out.print(a.charAt(Integer.parseInt(a)));
    }
}
