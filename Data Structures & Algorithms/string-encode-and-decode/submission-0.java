class Solution {

    public String encode(List<String> strs) {
        String answer = "";
        for (String s : strs) {
            answer += s.length() + "#" + s;
        }

        return answer;
    }

    public List<String> decode(String str) {
        String decoding = str;
        List<String> answer = new ArrayList<>();

        while (decoding.length() > 0) {
            // System.out.println(decoding);
            String[] split = decoding.split("#");
            int length = Integer.parseInt(split[0]);
            int digits = (int) Math.log10(length) + 1;

            if (length == 0) {
                answer.add("");
                decoding = decoding.substring(2);
                continue;
            }

            String s = decoding.substring(digits + 1, digits + length + 1);
            answer.add(s);

            decoding = decoding.substring(digits + length + 1);
        }

        return answer;
    }
}
