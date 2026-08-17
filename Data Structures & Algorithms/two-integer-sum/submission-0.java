class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffToIndex = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (diffToIndex.get(nums[i]) != null) {
                int index = diffToIndex.get(nums[i]);

                int[] pair = {index, i};

                return pair;
            }

            diffToIndex.put(diff, i);
        }

        return null;
    }
}
