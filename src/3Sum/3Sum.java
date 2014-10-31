public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        if (num.length < 3) {
            return resultList;
        }
        Arrays.sort(num);
        
        if (num[0] > 0 || num[num.length-1] < 0) {
            return resultList;
        }
        for (int left = 0; left < num.length - 2; left++) {
            if (left > 0 && num[left - 1] == num[left]) {
                continue;
            }
            int sum1 = num[left];
            if (sum1 > 0) {
                break;
            }
            int mid = left + 1;
            int right = num.length - 1;
            while (mid < right) {
                if (mid > left + 1 && num[mid - 1] == num[mid]) {
                    mid++;
                    continue;
                }
                int sum3 = sum1 + num[mid] + num[right];
                if (sum3 == 0) {
                    List<Integer> list = new LinkedList<Integer>();
                    list.add(num[left]);
                    list.add(num[mid]);
                    list.add(num[right]);
                    resultList.add(list);
                    mid ++;
                    right --;
                } else if (sum3 > 0) {
                    right --;
                } else {
                    mid ++;
                }
            }
        }
        return resultList;
    }
}
