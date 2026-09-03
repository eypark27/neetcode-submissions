class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int L = 0;
        int R = 0;
        Set<Integer> set = new HashSet<>();

        if (nums.length == 1) {
            return false;
        }

        // 1 2 4 3 5 3 

        // k = 2

        while (R < nums.length) {
            if (R == 0) {
                set.add(nums[R]);
            }

            if (windowSize(L, R) == k + 1) {
                int exclude = nums[L];
                set.remove(exclude);
                L++;
            }

            R++;
            if (R < nums.length) {
                int newMember = nums[R];
                if (set.contains(newMember)) {
                    return true;
                }
                set.add(newMember);
            }
        }

        return false;
    }

    private int windowSize(int L, int R) {
        return R - L + 1;
    }
}