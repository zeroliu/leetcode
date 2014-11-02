public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates, target, 0);
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
            List<List<Integer>> tmp = combinationSum(candidates, target-elm, start);
            for (List<Integer> list : tmp) {
                ((LinkedList<Integer>)list).addFirst(elm);
                results.add(list);
            }    
        }
        
        //not pick smallest
        List<List<Integer>> tmp = combinationSum(candidates, target, ++start);
        for (List<Integer> list : tmp) {
            results.add(list);
        } 
        
        return results;
    }
    
    
}
