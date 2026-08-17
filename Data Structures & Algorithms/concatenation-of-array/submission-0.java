class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] solution = new int[nums.length * 2];

        for (int i = 0; i < solution.length; i++) {
            solution[i] = nums[i % nums.length];
        }

        return solution;
    }
}