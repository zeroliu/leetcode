public class Solution {
    public String strStr(String haystack, String needle) {
        int nSize = needle.length();
        int hSize = haystack.length();
        if (hSize < nSize) {
            return null;
        }
        if (nSize == 0) {
            return haystack;
        }
        int nSum = 0;
        int hSum = 0;
        for (int i=0; i<nSize; i++) {
            nSum += (int)needle.charAt(i);
            hSum += (int)haystack.charAt(i);
        }
        
        for (int i=0; i<=hSize-nSize; i++) {
            if (nSum == hSum) {
                if (haystack.substring(i, i+nSize).equals(needle)) {
                    return haystack.substring(i);
                }
            }
            if (i < hSize-nSize) {
                hSum -= (int)haystack.charAt(i);
                hSum += (int)haystack.charAt(i+nSize);
            }
        }
        
        return null;
    }
}
