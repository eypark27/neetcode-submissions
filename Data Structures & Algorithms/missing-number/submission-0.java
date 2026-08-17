class Solution {
    public int missingNumber(int[] nums) {
        int s = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            s += 1 + i;
            sum += nums[i];
        }

        return s - sum;
    }
}
