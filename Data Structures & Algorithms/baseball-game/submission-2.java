class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];

            switch (op) {
                case "+": {
                    int a = stack.pop();
                    int b = stack.pop();
                    int c = a + b;
                    stack.push(b);
                    stack.push(a);
                    stack.push(c);
                    break;
                }

                case "D": {
                    int a = stack.peek();
                    stack.push(2 * a);
                    break;
                }

                case "C": {
                    stack.pop();
                    break;
                }

                default: {
                    int a = Integer.parseInt(op);
                    stack.push(a);
                    break;
                }
            }
        }

        int total = 0;
        for (Integer score : stack) {
            total += score;
        }

        return total;
    }
}