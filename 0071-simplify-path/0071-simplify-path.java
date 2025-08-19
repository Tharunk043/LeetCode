class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");   // split by slash
        Deque<String> stack = new ArrayDeque<>();
        
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;  // skip empty or current dir
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();  // go back one directory
                }
            } else {
                stack.addLast(part);  // keep in correct order
            }
        }
        
        // build canonical path
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir);
        }
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
