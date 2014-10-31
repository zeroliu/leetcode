public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int diff = Integer.MAX_VALUE;
        int sum = Integer.MAX_VALUE;
        for (int left=0; left<num.length-2; left++) {
            int mid = left+1;
            int right = num.length-1;
            while(mid < right) {
                int tempSum = num[left] + num[mid] + num[right];
                int tempDiff = Math.abs(tempSum - target);
                if (tempDiff < diff) {
                    diff = tempDiff;
                    sum = tempSum;
                }
                if (tempSum == target) {
                    return tempSum;
                } else if (tempSum > target) {
                    right --;
                } else {
                    mid ++;
                }
            }
        }
        return sum;
    }
}
