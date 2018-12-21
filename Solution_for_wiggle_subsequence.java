public class Solution_for_wiggle_subsequence {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int count = 1;
        Boolean prevInc = null;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1] && (prevInc == null || !prevInc)) {
                prevInc = true;
                count++;
            } else if(nums[i] < nums[i - 1] && (prevInc == null || prevInc)) {
                prevInc = false;
                count++;
            }
        }
        return count;
    }
}
