class Solution {
    int[] memo;

    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }

        return Math.min(minCost(cost, 0), minCost(cost, 1));
    }

    private int minCost(int[] cost, int origin) {
        if (memo[origin] != -1) {
            return memo[origin];
        }

        if (origin >= cost.length - 2) {
            memo[origin] = cost[origin];
            return cost[origin];
        }

        int c = cost[origin];
        int answer = Math.min(c + minCost(cost, origin + 1), c + minCost(cost, origin + 2));

        memo[origin] = answer;

        return answer;
    }
}
