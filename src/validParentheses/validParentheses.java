public class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i=0; i<s.length(); i++) {
            char sign = s.charAt(i);
            if (map.containsKey(sign)) {
                stack.addFirst(sign);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                char openSign = stack.pop();
                if (map.get(openSign) != sign) {
                    return false;
                }
            }
        }
        if (stack.size() != 0) {
            return false;
        }
        return true;
    }
}
