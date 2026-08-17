class Solution {
    public int hammingWeight(int n) {
        int a = 1 << 31;
        int answer = 0;

        while (a != 0) {

            if ((a & n) != 0) {
                answer++;
            }

            a = a >>> 1;
        }

        return answer;
    }
}
