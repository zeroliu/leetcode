public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int l = gas.length;
        if (l == 0) return -1;
        int[] diff = new int[l];
        int maxIndex = 0;
        for (int i=0; i<l; i++) {
            diff[i] = gas[i] - cost[i];
            if (diff[i] > diff[maxIndex]) {
                maxIndex = i;
            }
        }
        
        int start = maxIndex;
        int current = (start+1) % l;
        int sum = diff[start];
        if (sum < 0) return -1;
        while (current != start) {
            if (sum + diff[current] < 0) {
                start -= 1;
                if (start < 0) {
                    start = l-1;
                }
                sum += diff[start];
            } else {
                sum += diff[current];
                current = (current + 1) % l;
            }
        }
        return (sum >= 0) ? start : -1;
    }
}
