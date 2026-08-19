class Solution {
    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;

        while (max >= min) {
            int mid = (max + min) / 2;
            int midNum = nums[mid];

            if (midNum == target) {
                return mid;
            }

            else if (midNum < target) {
                min = mid + 1;
            }

            else {
                max = mid - 1;
            }
        }

        return -1;
    }
}
