/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length == 0) return 0;
        int max = 0;
        for (int i=0; i<points.length-max; i++) {
            int dup = 1;
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            map.put("-", 0);
            for (int j=i+1; j<points.length; j++) {
                int dx = points[j].x - points[i].x;
                int dy = points[j].y - points[i].y;
                if (dx == 0 && dy ==0) {
                    dup ++;
                } else {
                    String key = generateKey(dx, dy);
                    int tmp = map.containsKey(key) ? map.get(key) : 0;
                    map.put(key, tmp+1);
                }
            }
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Double, Integer> pairs = (Map.Entry<Double, Integer>)it.next();
                if (pairs.getValue() + dup > max) {
                    max = pairs.getValue() + dup;
                }
            }
        }
        return max;
    }
    
    String generateKey(int dx, int dy) {
        int a = 0;
        int b = 0;
        //ax + by + c = 0
        if (dx == 0) {
            a = 1;
        } else if (dy == 0) {
            b = 1;
        } else {
            int gcdV = gcd(Math.abs(dx), Math.abs(dy));
            b = Math.abs(dx) / gcdV;
            a = Math.abs(dy) / gcdV;
            if (dx * dy < 0) {
                a = -a;
            }
        }
        return a + "-" + b;
    }
    
    int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        if (x<y) {
            return gcd(y, x);
        }
        return gcd(y, x%y);
    }
}
