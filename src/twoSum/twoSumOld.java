package twoSum;

import java.util.HashMap;
import java.util.LinkedList;

public class twoSumOld {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
        int[] result = null;
        for (int i=0; i<numbers.length; i++) {
            int number = numbers[i];
            if (map.containsKey(number)) {
                map.get(number).add(i);
            } else {
                LinkedList<Integer> list = new LinkedList<Integer>();
                list.add(i);
                map.put(number, list);
            }
        }

        for (int i=0; i<numbers.length; i++) {
            int number = numbers[i];
            int diff = target - number;
            int otherIndex = -1;
            if (map.containsKey(diff)) {
                LinkedList<Integer> list = map.get(diff);
                if (diff == number && list.size() > 1){
                    otherIndex = list.get(1);
                } else if (diff != number) {
                    otherIndex = list.get(0);
                }
            }
            if (otherIndex > 0) {
                result = new int[]{i+1, otherIndex+1};
                break;
            }
        }

        return result;
    }
}
