class Solution {
    public int searchInsert(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;

        while (R >= L) {
            int mid = (L + R) / 2;
            int midVal = nums[mid];

            // found
            if (midVal == target) {
                return mid;
            }

            // edge case: candidate is at the beginning
            if (mid == 0 && midVal > target) {
                return mid;
            }

            // edge case: candidate is at the end 
            if (mid == nums.length - 1 && midVal < target) {
                return mid + 1;
            }

            // edge case: insertion
            if (R - L == 1) {
                if (nums[R] < target) {
                    return R + 1;
                }

                if (nums[L] > target) {
                    return L;
                }

                return R;
            }

            if (midVal < target) {
                L = mid;
                continue;
            }

            if (midVal > target) {
                R = mid;
                continue;
            }
        }

        return 0;
    }
}