class Solution {
    private int index;
    
    private int calculateValue(String s) {
        s = s.replaceAll("\\s+", "")
             .replaceAll("--", "+")
             .replaceAll("-\\+", "-")
             .replaceAll("\\+-", "-")
             .replaceAll("\\+\\+", "-")
             .replaceAll("\\+", " + ")
             .replaceAll("-", " - ");
        String[] express = s.split("\\s+");
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(express[i] == null || express[i].length() == 0) i++;
        if(express[i].equals("-")) {
            stack.push(Integer.parseInt(express[i + 1]) * -1);
            i = i + 2;
        }
        for(;i < express.length;++i) {
            if(express[i].equals("+")) {
                int num1 = stack.pop();
                int num2 = Integer.parseInt(express[i + 1]);
                i++;
                stack.push(num1 + num2);
            } else if(express[i].equals("-")) {
                int num1 = stack.pop();
                int num2 = Integer.parseInt(express[i + 1]);
                i++;
                stack.push(num1 - num2);
            } else {
                stack.push(Integer.parseInt(express[i]));
            }
        }
        return stack.pop();
    }
    
    private String calculateHelper(String s) {
        StringBuilder res = new StringBuilder();
        while(index < s.length()) {
            if(s.charAt(index) == ')') {
                index++;
                return String.valueOf(calculateValue(res.toString()));
            } else if(s.charAt(index) == '(') {
                index++;
                res.append(calculateHelper(s));    
            } else {
                res.append(s.charAt(index));
                index++;
            }
        }
        return res.toString();
    }
    
    public int calculate(String s) {
        index = 0;
        String res = calculateHelper(s);
        return calculateValue(res);
    }
}