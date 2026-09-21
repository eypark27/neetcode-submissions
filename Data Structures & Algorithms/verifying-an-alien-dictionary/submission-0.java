class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> alphabet = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            Character c = order.charAt(i);
            alphabet.put(c, i);
        }

        Comparator<String> comparator = (s1, s2) -> {
            int len = Math.min(s1.length(), s2.length());

            for (int i = 0; i < len; i++) {
                Character c1 = s1.charAt(i);
                Character c2 = s2.charAt(i);

                int o1 = alphabet.get(c1);
                int o2 = alphabet.get(c2);

                if (o1 != o2) {
                    return o1 - o2;
                }
            }

            return s1.length() - s2.length();
        };

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            if (comparator.compare(w1, w2) > 0) {
                return false;
            }
        }

        return true;
    }
}