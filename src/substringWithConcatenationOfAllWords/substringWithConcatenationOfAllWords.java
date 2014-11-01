public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new LinkedList<Integer>();
        int wordsLength = L.length;
        int stringLength = S.length();
        if (wordsLength == 0) {
            return result;
        }
        int unitLength = L[0].length();
        if (stringLength < unitLength) {
            return result;
        }
        HashMap<String, Integer> expected = generateMap(L);
        HashMap<String, Integer> actual = new HashMap<String, Integer>();
        for (int i=0; i<unitLength; i++) {
            int left = i;
            int count = 0;
            actual.clear();
            for (int j=i; j<=stringLength - unitLength; j += unitLength) {
                String sub = S.substring(j, unitLength + j);
                if (!expected.containsKey(sub)) {
                    left = j + unitLength;
                    actual.clear();
                    count = 0;
                    continue;
                }
                
                if (actual.containsKey(sub)) {
                    actual.put(sub, actual.get(sub) + 1);
                } else {
                    actual.put(sub, 1);
                }
                count ++;
                
                while (actual.get(sub) > expected.get(sub)) {
                    String tmp = S.substring(left, unitLength + left);
                    if (actual.get(tmp) == 1) {
                        actual.remove(tmp);
                    } else {
                        actual.put(tmp, actual.get(tmp) - 1);
                    }
                    left += unitLength;
                    count --;
                    if (tmp.equals(sub)) {
                        break;
                    }
                }
                
                if (count == wordsLength) {
                    result.add(left);
                    String tmp = S.substring(left, unitLength + left);
                    if (actual.get(tmp) == 1) {
                        actual.remove(tmp);
                    } else {
                        actual.put(tmp, actual.get(tmp) - 1);
                    }
                    left += unitLength;
                    count--;
                }
            }
        }
        return result;
    }
    
    HashMap<String, Integer> generateMap(String[] L) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String s:L) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s)+1);
            } else {
                map.put(s, 1);
            }
        }
        return map;
    }
}
