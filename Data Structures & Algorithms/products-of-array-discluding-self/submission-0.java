class Solution {

    private int[] calculateLeftProduct(int[] nums) {
        int[] answer = new int[nums.length];
        int product = 1;
        answer[0] = product;

        for (int i = 1; i < answer.length; i++) {
            product *= nums[i - 1];
            answer[i] = product;
        }

        return answer;
    }

    private int[] calculateRightProduct(int[] nums) {
        int[] answer = new int[nums.length];
        int n = nums.length - 1;
        int product = 1;
        answer[n] = product;

        for (int i = n - 1; i >= 0; i--) {
            product *= nums[i + 1];
            answer[i] = product;
        }

        return answer;
    }    

    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int[] left = calculateLeftProduct(nums);
        int[] right = calculateRightProduct(nums);

        for (int i = 0; i < answer.length; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }
}  
