public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        HashSet<String> cache = new HashSet<String>();
        return wordBreak(s, dict, cache);
    }
    public boolean wordBreak(String s, Set<String> dict, HashSet<String> cache) {
        if (cache.contains(s)) {
            return false;
        }
        int sl = s.length();
        if (sl == 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<sl; i++) {
            char c = s.charAt(i);
            sb.append(c);
            if (dict.contains(sb.toString())) {
                String newStr = s.substring(i+1);
                if (wordBreak(newStr, dict, cache)) {
                    return true;
                } else {
                    cache.add(newStr);
                }
            }
        }
        return false;
    }
}
