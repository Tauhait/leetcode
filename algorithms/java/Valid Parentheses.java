class Solution {
    private boolean isPair(char left, char right) {
        if(left == '(' && right == ')') return true;
        if(left == '{' && right == '}') return true;
        if(left == '[' && right == ']') return true;
        return false;
    }
    
    public boolean isValid(String s) {
        if(s == null || s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == ')' || c == '}' || c == ']') {
                if(stack.empty()) return false;
                char top = stack.pop();
                if(!isPair(top, c)) return false;
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }
}