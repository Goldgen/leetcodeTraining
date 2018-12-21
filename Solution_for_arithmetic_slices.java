public class Solution_for_arithmetic_slices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;
        int diff = A[1] - A[0];
        int start = 0;
        int result = 0;
        for (int i = 2; i < A.length; i++) {
            int curDiff = A[i] - A[i - 1];
            if (curDiff == diff) {
                result += i - start - 1;
            } else {
                diff = curDiff;
                start = i - 1;
            }
        }
        return result;
    }
}
