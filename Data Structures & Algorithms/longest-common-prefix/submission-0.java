class Solution {
    public String longestCommonPrefix(String[] strs) {
        String answer = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            answer = commonPrefix(answer, s);

            if (answer.equals("")) {
                return answer;
            }
        }

        return answer;
    }

    private String commonPrefix(String s1, String s2) {
        int len = (int) Math.min(s1.length(), s2.length());
        int l = 0;

        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                l++;
            }
            else {
                break;
            }
        }

        return s1.substring(0, l);
    }
}