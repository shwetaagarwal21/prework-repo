public class Solution {
    public int isPalindrome(String A) {
        int size = A.length();
        String str = A.toLowerCase();
        int l = 0, r = size - 1;
        while(l <= r){
            if(str.charAt(l) == str.charAt(r)){
                l++;
                r--;
            }else if(!Character.isLetterOrDigit(str.charAt(l))){
                l++;
            }else if(!Character.isLetterOrDigit(str.charAt(r))){
                r--;
            }else
                return 0;
        }
        return 1;
    }
}
