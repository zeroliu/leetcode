public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        if (num.length < 4) {
            return resultList;
        }
        Arrays.sort(num);
        for (int left=0; left<num.length-3; left++) {
            if (left > 0 && num[left] == num[left-1]) {
                continue;
            }
            for (int midLeft=left+1; midLeft<num.length-2; midLeft++) {
                if (midLeft > left + 1 && num[midLeft] == num[midLeft-1]) {
                    continue;
                }
                int midRight = midLeft + 1;
                int right = num.length - 1;
                while (midRight < right) {
                    if (midRight > midLeft+1 && num[midRight] == num[midRight - 1]) {
                        midRight ++;
                        continue;
                    }
                    if (right < num.length-1 && num[right] == num[right+1]) {
                        right --;
                        continue;
                    }
                    int sum = num[left] + num[midLeft] + num[midRight] + num[right];
                    if (sum == target) {
                        List<Integer> list = new LinkedList<Integer>();
                        list.add(num[left]);
                        list.add(num[midLeft]);
                        list.add(num[midRight]);
                        list.add(num[right]);
                        resultList.add(list);
                        midRight ++;
                        right --;
                    } else if (sum > target){
                        right --;
                    } else {
                        midRight ++;
                    }
                }
            }
        }
        return resultList;
    }
}
