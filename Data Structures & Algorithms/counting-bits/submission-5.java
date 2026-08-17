class Solution {
    public int[] countBits(int n) {
        int[] solution = new int[n + 1];


        for (int i = 1; i <= n; i++) {

            double logI = log2(i);
            
            if (logI % 1 == 0) {
                solution[i] = 1;
            }

            else {
                int floorLogI = (int) Math.floor(logI);
                solution[i] = 1;
                
                int diff = (int) Math.pow(2, floorLogI);
                solution[i] += solution[i - diff];
            }
        }

        return solution;
    }

    private double log2(double a) {
        return Math.log10(a) / Math.log10(2);
    }
}
