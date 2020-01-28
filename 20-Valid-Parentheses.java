class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() % 2 == 1) return false;
        Stack<String> stack = new Stack<>();
        String[] strs = s.split("");
        for (String str : strs) {
            if (str.equals(")")) {
                if (stack.empty() || !stack.pop().equals("(")) {
                    return false;
                }
            } else if (str.equals("]")) {
                if (stack.empty() || !stack.pop().equals("[")) {
                    return false;
                }
            } else if (str.equals("}")) {
                if (stack.empty() || !stack.pop().equals("{")) {
                    return false;
                }
            } else {
                stack.push(str);
            }
        }
        return stack.empty();
    }
}
