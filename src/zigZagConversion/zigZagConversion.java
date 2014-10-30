package zigZagConversion;

/**
 * Created by zeroliu on 10/26/14.
 */
public class zigZagConversion {
    public String convert(String s, int nRows) {
        if (nRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int size = s.length();
        for (int r=0; r<nRows; r++) {
            int index = r;
            if (r == 0 || r == nRows-1) {
                while (index < size) {
                    sb.append(chars[index]);
                    index += 2*nRows-2;
                }
            } else {
                while (index < size) {
                    sb.append(chars[index]);
                    index += (nRows - r - 1) * 2;
                    if (index < size) {
                        sb.append(chars[index]);
                        index += r*2;
                    }
                }
            }
        }
        return sb.toString();
    }
}
