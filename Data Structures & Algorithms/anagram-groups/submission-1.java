class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<Map<Character, Integer>> anagrams = new ArrayList<>();
        List<List<String>> solution = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            Map<Character, Integer> anagram = formAnagramProfile(s);
            int match = matchAnagram(anagrams, anagram);

            if (match == -1) {
                anagrams.add(anagram);
                List<String> list = new ArrayList<>();
                list.add(s);
                solution.add(list);
            }

            else {
                List<String> list = solution.get(match);
                list.add(s);
            }
        }

        return solution;
    }

    private int matchAnagram(List<Map<Character, Integer>> anagrams, Map<Character, Integer> anagram) {
        for (int i = 0; i < anagrams.size(); i++) {
            if (anagram.equals(anagrams.get(i))) {
                return i;
            }
        }

        return -1;
    }

    private Map<Character, Integer> formAnagramProfile(String s) {
        Map<Character, Integer> anagram = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            anagram.merge(c, 1, Integer::sum);
        }

        return anagram;
    }
}
