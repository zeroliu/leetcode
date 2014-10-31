public class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('0', "");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        return letterCombinations(digits, 0, map);
    }
    
    List<String> letterCombinations(String digits, int start, HashMap<Character, String> map) {
        List<String> resultList = new LinkedList<String>();
        if (start >= digits.length()) {
            resultList.add("");
            return resultList;
        }
        
        List<String> sequalList = letterCombinations(digits, start+1, map);
        char digit = digits.charAt(start);
        String letters = map.get(digit);
        for (int i=0; i<letters.length(); i++) {
            for (String combination : sequalList) {
                resultList.add(letters.charAt(i)+combination);
            }
        }
        return resultList;
    }
}
