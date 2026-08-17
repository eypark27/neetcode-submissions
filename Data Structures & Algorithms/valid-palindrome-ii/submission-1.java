class Solution {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, false);
    }

    boolean validPalindrome(String s, boolean dontDelete) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            // happy case
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }

            // delete
            if (!dontDelete) {
                String leftDeleted = s.substring(i + 1, j + 1);
                String rightDeleted = s.substring(i, j);

                return validPalindrome(leftDeleted, true) || validPalindrome(rightDeleted, true);
            }


            // not a palindrome
            return false;
        }

        return true;
    }
}