public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatchHelper(s, 0, p, 0);
    }
    
    boolean isMatchHelper(String s, int si, String p, int pi) {
        int sl = s.length();
        int pl = p.length();
        int tmpS = 0;
        int tmpP = 0;
        boolean star = false;
        while (si < sl && (pi < pl || star)) {
            if ((pi < pl && p.charAt(pi) == '?') || (pi < pl && s.charAt(si) == p.charAt(pi))) {
                si ++;
                pi ++;
            } else if (pi < pl && p.charAt(pi) == '*') {
                star = true;
                pi ++;
                tmpP = pi;
                tmpS = si;
            } else {
                if (!star) return false;
                pi = tmpP;
                si = ++tmpS;
            }
        }
        if (si == sl) {
            while (pi < pl && p.charAt(pi) == '*') {
                pi ++;
            } 
            if (pi == pl) return true;
        }
        return false;
    }
}
