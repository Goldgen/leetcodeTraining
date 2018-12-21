public class Solution_for_max_sum_of_rectangle_no_larger_than_k {
    private int[][] sum;

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        int temp = 0;
        int diff = Integer.MAX_VALUE;
        assignSumValue(matrix);

        for(int i=0; i<row; i++){
            for(int q=i; q<row; q++){
                for(int j=0; j<col; j++){
                    for(int m=j; m<col; m++){
                        temp = sumRegion(i, j, q, m);
                        if(temp > k) continue;
                        else if(temp == k) return temp;
                            //temp < k
                        else{
                            if(k - temp < diff){
                                max = temp;
                                diff = k-temp;
                            }
                        }
                    }
                }
            }
        }
        return max;

    }


    public void assignSumValue(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }
        sum = new int[matrix.length+1][matrix[0].length+1];

        for(int i=1; i<sum.length; i++){
            for(int j=1; j<sum[0].length; j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row1][col2+1] - sum[row2+1][col1] + sum[row1][col1];
    }
}
