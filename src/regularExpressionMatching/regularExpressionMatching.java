package regularExpressionMatching;

/**
 * Created by zeroliu on 10/27/14.
 */
public class regularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    boolean matchFirst(String s, int si, String p, int pi) {
        return (si < s.length() && p.charAt(pi) == s.charAt(si)) || (p.charAt(pi) == '.' && si < s.length());
    }

    boolean isMatch(String s, int si, String p, int pi) {
        if (pi == p.length()) {
            return si == s.length();
        }

        char check = p.charAt(pi);
        if (pi >= p.length() - 1 || p.charAt(pi+1) != '*') {
            if (!matchFirst(s, si, p, pi)) {
                return false;
            }
            return isMatch(s, si+1, p, pi+1);
        } else {
            if (isMatch(s, si, p, pi + 2)) {
                return true;
            }
            while (matchFirst(s, si, p, pi)) {
                si++;
                if (isMatch(s, si, p, pi+2)) {
                    return true;
                }
            }
        }

        return false;
    }
}
