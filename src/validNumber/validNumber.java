public class Solution {
    public boolean isNumber(String s) {
        boolean foundNum = false;
        boolean hasFloat = false;
        boolean hasExp = false;
        s = s.trim();
        int sl = s.length();
        if (sl <= 0) return false;
        int i = 0;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }
        if (sl-i <= 0) return false;
        
        for (; i < sl; i++) {
            char c = s.charAt(i);
            if (c == '.') {
                if (hasFloat || hasExp) {
                    return false;
                }
                hasFloat = true;
                
            } else if (c == 'e') {
                if (hasExp || !foundNum) {
                    return false;
                } 
                i++;
                if (i >= sl) return false;
                if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    i++;
                    if (i >= sl) return false;
                }
                if (!isNum(s.charAt(i))) {
                    return false;
                }
                hasExp = true;
            } else if (isNum(c)) {
                foundNum = true;
                continue;
            } else {
                return false;
            }
        }
        return foundNum;
    }
    boolean isNum(char c) {
        int diff = c - '0';
        return diff >= 0 && diff <= 9;
    }
}
