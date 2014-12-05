public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new LinkedList<String>();
        if (s == null) { return results; }
        int l = s.length();
        if (l < 4 || l>16) {
            return results;
        }
        restoreIpAddressesHelper(s, new ArrayList<Integer>(), results);
        return results;
    }
    
    void restoreIpAddressesHelper(String s, ArrayList<Integer> buffer, List<String> results) {
        if (s.length() == 0 && buffer.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<4; i++) {
                sb.append(buffer.get(i));
                if (i != 3) {
                    sb.append(".");
                }
            }
            results.add(sb.toString());
        }
        
        if (s.length() == 0 || buffer.size() == 4) { return; }
        
        int digits = Math.min(3, s.length());
        int value = 0;
        for (int i=0; i<digits; i++) {
            if (value == 0 && i>0) { break;}
            value = (int)(s.charAt(i) - '0') + value * 10;
            if (value > 255) {break;}
            ArrayList<Integer> newBuffer = new ArrayList<Integer>(buffer);
            newBuffer.add(value);
            restoreIpAddressesHelper(s.substring(i+1), newBuffer, results);
        }
    }
}