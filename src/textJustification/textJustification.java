public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> results = new LinkedList<String>();
        LinkedList<String> cache = new LinkedList<String>();
        int count = L;
        int wl = words.length;
        if (wl == 0) { return results; }
        
        for (int i=0; i<wl; i++) {
            String word = words[i];
            if (count < word.length()) {
                results.add(generateString(cache, count, L, false));
                cache = new LinkedList<String>();
                count = L;
            }
            
            cache.add(word);
            count -= (word.length() + 1);
        }
        if (cache.size() > 0) {
            results.add(generateString(cache, count, L, true));
        }
        return results;
    }
    
    String generateString(LinkedList<String> cache, int count, int L, boolean isLast) {
        int cl = cache.size();
        StringBuilder sb = new StringBuilder();
        if (isLast) {
            for (int i=0; i<cl; i++) {
                sb.append(cache.poll());
                if (i != cl-1) {
                    sb.append(" ");
                }
            }
            sb.append(generateSpace(count+1));
            return sb.toString();
        }
        
        count += cl;
        
        if (cl == 1) {
            sb.append(cache.poll());
            sb.append(generateSpace(count));
            return sb.toString();
        }
        
        int regularSpace = count / (cl-1);
        int extraSpace = count % (cl-1);
        for (int i=0; i<cl; i++) {
            sb.append(cache.poll());
            if (i != cl-1) {
                if (i < extraSpace) {
                    sb.append(generateSpace(regularSpace + 1));
                } else {
                    sb.append(generateSpace(regularSpace));
                }
            }
        }
        return sb.toString();
    }
    
    String generateSpace(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
