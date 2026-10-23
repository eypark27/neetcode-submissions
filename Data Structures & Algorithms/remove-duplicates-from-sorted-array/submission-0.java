class Solution {
    private boolean newValue(int[] nums, int i) {
        if (i == 0) {
            return false;
        }

        return nums[i] > nums[i - 1];
    }

    public int removeDuplicates(int[] nums) {
        int j = 1;

        for (int i = 0; i < nums.length; i++) {
            if (newValue(nums, i)) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}