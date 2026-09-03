class Solution {
    public int majorityElement(int[] nums) {
        int remembered = 0;
        int tally = 0;

        for (int i = 0; i < nums.length; i++) {
            if (tally == 0) {
                remembered = nums[i];
                tally++;
            }
            else if (nums[i] == remembered) {
                tally++;
            }
            else {
                tally--;
            }
        }

        return remembered;
    }
}