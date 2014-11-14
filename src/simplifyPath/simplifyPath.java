public class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<String>();
        int sl = path.length();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<sl; i++) {
            if (path.charAt(i) == '/') {
                if (sb.length() == 0 || sb.toString().equals(".")) {
                    sb = new StringBuilder();
                    continue;
                }
                if (sb.toString().equals("..")) {
                    if (stack.size() > 0) {
                        stack.poll();
                    }
                } else {
                    stack.addFirst(sb.toString());
                }
                sb = new StringBuilder();
            } else {
                sb.append(path.charAt(i));
            }
        }
        if (sb.length() > 0 && !sb.toString().equals(".")) {
            if (sb.toString().equals("..")) {
                if (stack.size() > 0) {
                    stack.poll();
                }
            } else {
                stack.addFirst(sb.toString());
            }
        }
        if (stack.size() == 0) {
            return "/";
        }
        sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.insert(0, "/" + stack.poll());
        }
        return sb.toString();
    }
}
