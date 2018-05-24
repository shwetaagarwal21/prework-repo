/*
Longest Substring Without Repeat
Given a string,
find the length of the longest substring without repeating characters.
Example:
The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
For "bbbbb" the longest substring is "b", with the length of 1.
*/
public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String A) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
    
        while (j < A.length()) {
            if (!set.contains(A.charAt(j))) {
                set.add(A.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(A.charAt(i++));
            }
        }
    
        return max;
    }
}
