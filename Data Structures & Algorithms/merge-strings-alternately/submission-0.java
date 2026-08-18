class Solution {
    public String mergeAlternately(String word1, String word2) {
        int max = (int) Math.max(word1.length(), word2.length());
        String solution = "";

        for (int i = 0; i < max; i++) {
            if (i < word1.length()) {
                solution += word1.charAt(i);
            }

            if (i < word2.length()) {
                solution += word2.charAt(i);
            }
        }

        return solution;
    }
}