public class Solution_for_sort_colours {
    public void sortColors(int[] nums) {

        if (nums.length == 1) {
            return;
        }
        int j=0, k=nums.length-1;
        for (int i=0; i<nums.length;) {
            if (nums[i] == 0) {
                swap(nums, i, j);
                j++;
                i++;
            }
            else if (nums[i] == 2 && i<k) {
                swap(nums, i, k);
                k--;
            }
            else {
                i++;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
