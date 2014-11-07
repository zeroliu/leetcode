public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<num.length; i++) {
            list.add(num[i]);
        }
        return permute(list);
    }
    
    List<List<Integer>> permute(List<Integer> num) {
        int pos = 0;
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        results.add(num);
        while (pos < num.size()) {
            int size = results.size();
            for (int i=0; i<size; i++) {
                for (int j=pos+1; j<results.get(i).size(); j++) {
                    List<Integer> list = new ArrayList<Integer>(results.get(i));
                    int tmp = list.get(pos);
                    list.set(pos, list.get(j));
                    list.set(j, tmp);
                    results.add(list);
                }
            }
            pos++;
        }
        return results;
    }
}
