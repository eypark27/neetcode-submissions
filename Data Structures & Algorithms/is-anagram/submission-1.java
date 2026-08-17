class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> charIndexMap = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (charIndexMap.get(c) == null) {
                charIndexMap.put(c, 1);
            }
            else {
                int val = charIndexMap.get(c);
                charIndexMap.put(c, val + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            if (charIndexMap.get(c) == null) {
                return false;
            }
            else {
                int val = charIndexMap.get(c);
                charIndexMap.put(c, val - 1);
            }
        }

        for (Integer i : charIndexMap.values()) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
