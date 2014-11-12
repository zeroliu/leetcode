/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> results = new LinkedList<Interval>();
        if (intervals == null || intervals.size() == 0) return results;
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.start < i2.start) {
                    return -1;
                } else if (i1.start > i2.start) {
                    return 1;
                } else if (i1.end < i2.end) {
                    return -1;
                } else if (i1.end > i2.end) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        
        results.add(intervals.get(0));
        for (int i=1; i<intervals.size(); i++) {
            Interval current = intervals.get(i);
            Interval last = ((LinkedList<Interval>)results).getLast();
            if (canMerge(current, last)) {
                last.end = Math.max(current.end, last.end);
            } else {
                results.add(current);
            }
        }
        return results;
     }
     
     boolean canMerge(Interval i1, Interval i2) {
         return (i1.start <= i2.end && i1.end >= i2.start);
     }
}
