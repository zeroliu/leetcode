public class Solution {
    public int lengthOfLastWord(String s) {
        int sl = s.length();
        int count = 0;
        boolean started = false;
        for (int i=sl-1; i>=0; i--) {
            if (!started && s.charAt(i) != ' '){
                started = true;
            } 
            
            if (started && s.charAt(i) == ' ') {
                break;
            }
            
            if (started) {
                count++;
            }
        }
        return count;
    }
}
