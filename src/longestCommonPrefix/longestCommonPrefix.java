public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String prefix = strs[0];
        int right = prefix.length() - 1;
        for (int i=0; i<strs.length; i++) {
            if (strs[i].length() - 1 < right) {
                right = strs[i].length() - 1;
            }
            for (int charIndex=0; charIndex<=right; charIndex++) {
                if (prefix.charAt(charIndex) != strs[i].charAt(charIndex))
                {
                    right = charIndex - 1;
                }
            }
        }
        if (right < 0) {
            return "";
        }
        return prefix.substring(0, right+1);
    }
}
