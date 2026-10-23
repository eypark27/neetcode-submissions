class Solution {
    private void swap(int[] nums, int a, int b) {
        int buffer = nums[a];
        nums[a] = nums[b];
        nums[b] = buffer;
    }

    public void sortColors(int[] nums) {
        int redIndex = 0;
        int blueIndex = nums.length - 1;
        int i = 0;

        while (i <= blueIndex) {
            int color = nums[i];

            if (color == 0) {
                swap(nums, i, redIndex);
                redIndex++;
                i++;
            }

            else if (color == 1) {
                i++;
            }

            else if (color == 2) {
                swap(nums, i, blueIndex);
                blueIndex--;
            }
        }
    }
}