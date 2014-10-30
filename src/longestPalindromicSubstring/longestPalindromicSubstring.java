package longestPalindromicSubstring;

/**
 * Created by zeroliu on 10/26/14.
 */
public class longestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() <=1) {
            return s;
        }
        char[] chars = s.toCharArray();

        String max = "";
        for (int i=0; i<chars.length-1; i++) {
            String p = findPalindromic(chars, i, i);
            if (p.length() > max.length()){
                max = p;
            }
            p = findPalindromic(chars, i, i+1);
            if (p.length() > max.length()){
                max = p;
            }
        }
        return max;
    }

    String findPalindromic(char[] chars, int left, int right) {
        if (chars[left] != chars[right]) {
            return "";
        }

        int size = chars.length;
        while (left >= 0 && right < size && chars[left] == chars[right]) {
            left--;
            right++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(chars, left+1, right-1-left);
        return sb.toString();
    }
}
