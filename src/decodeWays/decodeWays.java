public class Solution {
    public int numDecodings(String s) {
        HashMap<String, Integer> cache = new HashMap<String, Integer>();
        if (s==null || s.length()==0) {return 0;}
        return numDecodings(s, cache);
    }
    
    int numDecodings(String s, HashMap<String, Integer> cache) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        if (s.length() == 0) {
            return 1;
        }
        
        if (s.charAt(0) - '0' == 0) {return 0;}
        int num = numDecodings(s.substring(1), cache);
        //double num
        if (s.length() >= 2) {
            int code = (s.charAt(0) - '0') * 10 + s.charAt(1) - '0';
            if (code <= 26) {
                num += numDecodings(s.substring(2), cache);
            }
        }
        cache.put(s, num);
        return num;
    }
}