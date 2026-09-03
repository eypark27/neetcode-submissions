class Solution {
    public int removeElement(int[] nums, int val) {
        int[] newNums = new int[nums.length];

        // Build new nums
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                newNums[k] = nums[i];
                k++;
            }
        }

        // Replace nums
        for (int i = 0; i < newNums.length; i++) {
            nums[i] = newNums[i];
        }

        return k;
    }
}