import java.util.Arrays;

public class Solution_for_partition_to_k_equal_sum_subsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums.length == 0 || k == 0)return false;
        Arrays.sort(nums);
        int sum = 0;
        for(int index:nums){
            sum += index;
        }
        if(sum%k != 0 || sum < k)return false;
        sum /= k;
        return helper(nums,new int[k],nums.length-1,sum);

    }

    private boolean helper(int[] nums, int[]k_helper, int index,int sum){
        if (index == -1) {
            for (int s : k_helper) if (s != sum) return false;
            return true;
        }

        int num = nums[index];

        for (int i = 0; i < k_helper.length; i++) {
            if (k_helper[i] + num <= sum) {
                k_helper[i] += num;
                if (helper(nums,k_helper, index-1, sum)) return true;
                k_helper[i] -= num;
            }
        }
        return false;
    }
}
