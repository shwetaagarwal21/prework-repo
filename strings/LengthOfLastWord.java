public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        String str = A.trim();
        int len = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' ')
                len = 0;
            else
                len++;
        }
        return len;
    }
}
