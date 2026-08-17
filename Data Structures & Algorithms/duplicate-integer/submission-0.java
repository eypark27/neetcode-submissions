class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (map.get(num) != null) {
                return true;
            }

            map.put(num, true);
        }

        return false;
    }
}