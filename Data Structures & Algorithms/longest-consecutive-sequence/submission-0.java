class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            numSet.add(nums[i]);
        }

        boolean[] isBeginning = new boolean[n];
        for (int i = 0; i < n; i++) {
            int value = nums[i];
            if (!numSet.contains(value - 1)) {
                isBeginning[i] = true;
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (isBeginning[i]) {
                int value = nums[i];
                int candidate = 1;

                for (int j = 0; j < n; j++) {
                    if (numSet.contains(value + 1)) {
                        candidate++;
                        value++;
                    } else {
                        break;
                    }
                }

                if (candidate > answer) {
                    answer = candidate;
                }
            }
        }

        return answer;
    }
}
