/*
Word Break



Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given

s = "myinterviewtrainer",
dict = ["trainer", "my", "interview"].

Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/
public class Solution {
    public int wordBreak(String A, ArrayList<String> B) {
        boolean[] t = new boolean[A.length()+1];
        t[0] = true;
        for(int i=0;i<A.length();i++){
            if(!t[i])
                continue;
            for(String s : B){
                int len = s.length();
                int end = i+len;
                if(end > A.length())
                    continue;
                if(t[end])
                    continue;
                if(A.substring(i, end).equals(s)){
                    t[end] = true;
                }
            }
        }
        if(t[A.length()])
            return 1;
        else
            return 0;
    }
}
