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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> results = new LinkedList<Interval>();
        if (intervals.size() == 0) { 
            results.add(newInterval);
            return results;
        }
        
        int index = binarySearch(intervals, newInterval);
        ((ArrayList<Interval>)intervals).add(index, newInterval);
        results.add(intervals.get(0));
        for (int i=1; i<intervals.size(); i++) {
            Interval last = ((LinkedList<Interval>)results).getLast();
            Interval current = intervals.get(i);
            if (canMerge(last, current)) {
                last.end = Math.max(last.end, current.end);
            } else {
                results.add(current);
            }
        }
        return results;
    }
    
    boolean canMerge(Interval i1, Interval i2) {
        return i1.start <= i2.end && i1.end >= i2.start;
    }
    
    int binarySearch(List<Interval> intervals, Interval newInterval) {
        int start = 0;
        int end = intervals.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            Interval midInterval = intervals.get(mid);
            if (midInterval.start > newInterval.start) {
                end = mid - 1;
            } else if (midInterval.start < newInterval.start) {
                start = mid + 1;
            } else if (midInterval.end > newInterval.end) {
                end = mid - 1;
            } else if (midInterval.end < newInterval.end) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        
        return start;
    }
}
