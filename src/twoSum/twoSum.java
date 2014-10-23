package twoSum;

import java.util.HashMap;

/**
 * Created by zeroliu on 10/23/14.
 */
public class twoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<numbers.length; i++) {
            if (!map.containsKey(target - numbers[i])) {
                map.put(numbers[i], i);
            } else {
                result = new int[]{map.get(target-numbers[i])+1, i+1};
                break;
            }
        }

        return result;
    }
}
