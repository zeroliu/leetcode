public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict.size() == 0) {
            return 0;
        }
        
        dict.add(end);
        int result = 1;
        LinkedList<String> stack = new LinkedList<String>();
        LinkedList<String> buffer = new LinkedList<String>();
        stack.add(start);
        while (stack.size() > 0) {
            String str = stack.poll();
            for (int i=0; i<str.length(); i++) {
                char[] cs = str.toCharArray();
                for (char c='a'; c<='z'; c++) {
                    cs[i] = c;
                    String newString = new String(cs);
                    if (dict.contains(newString)) {
                        if (newString.equals(end)) {
                            return result+1;
                        }
                        buffer.add(newString);
                        dict.remove(newString);
                    }
                }
            }
            
            if (stack.size() == 0) {
                stack = buffer;
                buffer = new LinkedList<String>();
                result++;
            }
        }
        return 0;
    }
}
