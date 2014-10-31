public class Solution {
    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, 0);
    }
    
    List<String> generateParenthesis(int n, int opened) {
        List<String> resultList = new LinkedList<String>();
        if (n == 0 && opened == 0) {
            resultList.add("");
        }
        if (n > 0) {
            List<String> list = generateParenthesis(n-1, opened+1);
            for (String s : list) {
                resultList.add("(" + s);
            }
        }
        if (opened > 0) {
            List<String> list = generateParenthesis(n, opened-1);
            for (String s : list) {
                resultList.add(")" + s);
            }
        }
        return resultList;
    }
}
