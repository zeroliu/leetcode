public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i=1; i<n; i++) {
            result = countAndSay(result);
        }
        return result;
    }
    
    String countAndSay(String n) {
        StringBuilder sb = new StringBuilder();
        char previous = ' ';
        char current = '0';
        int count = 0;
        int p = n.length()-1;
        while (p >= 0) {
            current = n.charAt(p);
            p--;
            if (current == previous) {
                count ++;    
            } else {
                if (previous != ' ') {
                    sb.insert(0, previous);
                    sb.insert(0, count);
                }
                previous = current;
                count = 1;
            }
        }
        sb.insert(0, previous);
        sb.insert(0, count);
        return sb.toString();
    }
}
