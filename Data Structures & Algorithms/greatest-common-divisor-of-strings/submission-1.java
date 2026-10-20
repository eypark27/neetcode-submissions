class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String answer = "";

        for (int i = 1; i <= str1.length(); i++) {
            String sub = str1.substring(0, i);

            if (divides(str1, sub) && divides(str2, sub)) {
                answer = sub;
            }
        }

        return answer;
    }

    private boolean divides(String s, String t) {
        if (s.length() % t.length() != 0) {
            return false;
        }

        for (int i = 0; i < s.length(); i += t.length()) {
            String sub = s.substring(i, i + t.length());
            if (!sub.equals(t)) {
                return false;
            }
        }

        return true;
    }
}