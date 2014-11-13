public class Solution {
    public String minWindow(String S, String T) {
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        LinkedList<Integer> cache = new LinkedList<Integer>();
        
        int tl = T.length();
        if (tl == 0) { return ""; }
        for (int i=0; i<tl; i++) {
            char c = T.charAt(i);
            if (tMap.containsKey(c)) {
                tMap.put(c, tMap.get(c) + 1);
            } else {
                tMap.put(c, 1);
            }
        }
        int sl = S.length();
        if (sl == 0) { return ""; }
        
        int start = 0;
        int end = sl-1;
        boolean hasValided =false;
        
        for (int i=0; i<sl; i++) {
            char c = S.charAt(i);
            if (!tMap.containsKey(c)) { continue; }
            if (sMap.containsKey(c)) {
                sMap.put(c, sMap.get(c) + 1);
            } else {
                sMap.put(c, 1);
            }
            cache.add(i);
            
            //update cache
            while(cache.size() > 0) {
                int index = cache.getFirst();
                char firstChar = S.charAt(index);
                if (sMap.get(firstChar) > tMap.get(firstChar)) {
                    sMap.put(firstChar, sMap.get(firstChar) - 1);
                    cache.poll();
                } else {
                    break;
                }
            }
            
            if (hasValided || isValid(sMap, tMap)) {
                hasValided = true;
                int newStart = cache.getFirst();
                int newEnd = cache.getLast();
                if ((newEnd - newStart) <= (end - start)) {
                    end = newEnd;
                    start = newStart;
                }
            }
        }
        if (!hasValided) {
            return "";
        }
        return S.substring(start, end+1);
    }
    
    boolean isValid(HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry: tMap.entrySet()) {
            if (!sMap.containsKey(entry.getKey()) || sMap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
