class Solution {
    public boolean isPalindrome(String s) {
        
        int a = 0;
        int b = s.length() - 1;

        while (b > a) {

            Character c_a = s.charAt(a);
            if (!Character.isLetterOrDigit(c_a)) {
                a++;
                continue;
            }

            Character c_b = s.charAt(b);
            if (!Character.isLetterOrDigit(c_b)) {
                b--;
                continue;
            }

            Character c_aLower = Character.toLowerCase(c_a);
            Character c_bLower = Character.toLowerCase(c_b);

            if (c_aLower != c_bLower) {
                return false;
            }

            a++;
            b--;
        }

        return true;
    }
}
