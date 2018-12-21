import java.util.HashMap;

public class Solution_for_continuous_subarray_sum {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer prev = map.get(k == 0 ? sum : sum % k);
            if (prev != null) {
                if (i - prev > 1) {
                    return true;
                }
            } else {
                map.put(k == 0 ? sum : sum % k, i);
            }
        }
        return false;
    }
}
