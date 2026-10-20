class Solution {
    public String convertToTitle(int columnNumber) {
        int number = columnNumber;
        String answer = "";

        while (number > 0) {
            int digit = number % 26;
            // correct to Z
            if (digit == 0) {
                digit = 26;
            }
            char c = (char) (64 + digit);

            answer += c;
            number -= digit;
            number /= 26;

            // AZY = (25 * 1) + (26 * 26)
            // (26 * 1)
        }
    
        return new StringBuilder(answer).reverse().toString();
    }
}