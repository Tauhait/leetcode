class Solution {
    public int calculate(String s) {
         s = s.replaceAll("\\s+", "")
              .replaceAll("\\+", " + ")
              .replaceAll("-", " - ")
              .replaceAll("\\*", " * ")
              .replaceAll("/", " / ");
        String[] express = s.split("\\s+");
        Stack<String> stack = new Stack<>();
        for(int i = 0;i < express.length;++i) {
            if(express[i].equals("*") || express[i].equals("/")) {
                int num1 = Integer.parseInt(stack.pop());
                String op = express[i];
                int num2 = Integer.parseInt(express[i + 1]);
                i++;
                int res = 0;
                if(op.equals("*")) {
                    res = num1 * num2;
                } else {
                    res = num1 / num2;
                }
                stack.push(String.valueOf(res));
                
            } else {
                stack.push(express[i]);
            }
        }
        Stack<String> s2 = new Stack<>();
        while(!stack.empty()) {
            s2.push(stack.pop());
        }
        while(s2.size() > 1) {
            int num1 = Integer.parseInt(s2.pop());
            String op = s2.pop();
            int num2 = Integer.parseInt(s2.pop());
            int res = 0;
            if(op.equals("+")) {
                res = num1 + num2;
            } else {
                res = num1 - num2;
            }
            s2.push(String.valueOf(res));
        }
        return Integer.parseInt(s2.pop());
    }
}