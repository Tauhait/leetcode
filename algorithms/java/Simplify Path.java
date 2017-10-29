class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String p: paths) {
            if(p == null || p.length() == 0 || p.equals(".")) continue;
            else if(p.equals("..")){
                if(!stack.empty()) stack.pop();
            }
            else stack.push(p);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        if(sb.length() == 0) return "/";
        return sb.toString();
    }
}