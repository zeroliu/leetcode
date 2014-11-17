public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!Arrays.equals(c1, c2)) return false;
        int sl = s1.length();
        for (int i=1; i<sl; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0, i), s2.substring(sl-i)) && isScramble(s1.substring(i), s2.substring(0, sl-i))) return true;
        }
        return false;
    }
}
