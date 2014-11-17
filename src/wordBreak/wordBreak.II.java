public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> results = new LinkedList<String>();
        if (dict.size() == 0 || s.length() == 0) { return results; }
        int sl = s.length();
        ArrayList<LinkedList<Integer>> dp = new ArrayList<LinkedList<Integer>>(sl);
        for (int i=0; i<sl; i++) {
            dp.add(null);
        }
        for (int i=sl-1; i>=0; i--) {
            for (int j=i+1; j<=sl; j++) {
                if (dict.contains(s.substring(i, j))) {
                    if (j == sl || dp.get(j) != null) {
                        if (dp.get(i) == null) {
                            dp.set(i, new LinkedList<Integer>());
                        }
                        dp.get(i).add(j); 
                    }
                }
            }
        }
        if (dp.get(0) == null) {
            return results;
        }
        
        generate(s, dp, 0, new StringBuilder(), results);
        return results;
    }
    
    public void generate(String s, ArrayList<LinkedList<Integer>> dp, int index, StringBuilder sb, List<String> results) {
        if (index == s.length()) {
            results.add(sb.toString());
            return;
        }
        LinkedList<Integer> list = dp.get(index);
        for (int next: list) {
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(s.substring(index, next));
            if (next != s.length()) {
                newSb.append(" ");
            }
            generate(s, dp, next, newSb, results);
        }
    }
}
