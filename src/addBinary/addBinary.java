public class Solution {
    public String addBinary(String a, String b) {
        int al = a.length();
        int bl = b.length();
        if (al == 0) return b;
        if (bl == 0) return a;
        
        int counter = 0;
        int incrementor = 0;
        StringBuilder sb = new StringBuilder();
        while (counter < al || counter < bl) {
            int abit = counter < al ? a.charAt(al-1-counter)-'0' : 0;
            int bbit = counter < bl ? b.charAt(bl-1-counter)-'0' : 0;
            int sum = abit + bbit + incrementor;
            sb.insert(0, sum % 2);
            incrementor = sum / 2;
            counter++;
        }
        if (incrementor > 0) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
