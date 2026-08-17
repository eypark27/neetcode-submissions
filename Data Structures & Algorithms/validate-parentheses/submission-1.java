class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (!validClosing(stack, c)) {
                return false;
            }

            stack.pop();
        }

        if (!stack.empty()) {
            return false;
        }

        return true;
    }

    private boolean validClosing(Stack<Character> stack, Character c) {
        if (stack.empty()) {
            return false;
        }

        Character b = stack.peek();

        boolean parenthesis = (b == '(' && c == ')');
        boolean square = (b == '[' && c == ']');
        boolean curly = (b == '{' && c == '}');

        return parenthesis || square || curly;
    }
}
