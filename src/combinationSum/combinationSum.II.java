public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        return combinationSum(num, target, 0);
    }
    
    List<List<Integer>> combinationSum(int[] candidates, int target, int start) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        if (start >= candidates.length) {
            return results;
        }
        if (target < candidates[start]) {
            return results;
        }
        
        //pick smallest
        int elm = candidates[start];
        if (target-elm == 0) {
            List<Integer> list = new LinkedList<Integer>();
            list.add(elm);
            results.add(list);
        } else {
            List<List<Integer>> tmp = combinationSum(candidates, target-elm, start+1);
            for (List<Integer> list : tmp) {
                ((LinkedList<Integer>)list).addFirst(elm);
                results.add(list);
            }    
        }
        
        //not pick smallest
        int next = start+1;
        while (next < candidates.length && candidates[next] == candidates[start]) {
            next++;
        }
        List<List<Integer>> tmp = combinationSum(candidates, target, next);
        for (List<Integer> list : tmp) {
            results.add(list);
        } 
        
        return results;
    }
    
    
}
