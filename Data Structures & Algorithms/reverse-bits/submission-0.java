class Solution {
    public int reverseBits(int n) {
        int answer = 0;
        int max = 31;

        for (int i = 0; i <= max; i++) {
            int tester = 1 << i;

            if ((tester & n) != 0) {
                answer += 1 << (max - i);
            }
        }

        return answer;
    }
}
