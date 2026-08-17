class Solution {
    public void reverseString(char[] s) {
        char buffer = 'a';

        for (int i = 0; i < s.length / 2; i++) {
            buffer = s[s.length - 1 - i];
            s[s.length - 1 - i] = s[i];
            s[i] = buffer;
        }
    }
}