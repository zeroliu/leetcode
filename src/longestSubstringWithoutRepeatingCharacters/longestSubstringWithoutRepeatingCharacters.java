package longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.LinkedList;

public class longestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        LinkedList<Character> queue = new LinkedList<Character>();
        HashSet<Character> set = new HashSet<Character>();
        for (char c : chars) {
            if (set.contains(c)) {
                max = Math.max(max, queue.size());

                char head = queue.pop();
                while (head != c) {
                    set.remove(head);
                    head = queue.pop();
                }
            }
            queue.add(c);
            set.add(c);
        }
        return Math.max(max, queue.size());
    }
}