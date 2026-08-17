class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] solution = new int[k];
        Map<Integer, Integer> distribution = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            distribution.merge(num, 1, Integer::sum);
        }

        List<Integer> sortedEntries = distribution
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .map(e -> e.getKey())
            .collect(Collectors.toList());

        for (int i = 0; i < k; i++) {
            solution[i] = sortedEntries.get(i);
        }

        return solution;
    }
}
