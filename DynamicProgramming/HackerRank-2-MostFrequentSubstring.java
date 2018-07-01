/*
Most Frequent Substring
We have a string of length N. Can you figure out the number of occurrences of the most frequent substring in this string? We are only interested in substring of length from K to L and in each substring the number of distinct characters must not exceed M. The string contains only lower-case letters(a-z). 
Constraints:
2<=N<=100000
2<=K<=L<=26,L<N
2<=M<=26

Sample Input :-
5
2 4 26 // value of K L M
abcde 
Sample Output :-
1

The solution to the above problem is 
-Any substring between length K and L will be inserted into the trie.  
-Each trieNode also has a frequency counter which will be incremented when an already existing substring is inserted.
-While inserting, we need to check for the number of distinct characters in the given substring and not insert any substring which has distinct characters greater than m. In case, the number of distinct characters is greater than m, we return -1 as frequency from insertTrie function so as to know that the given substring was invalid and not inserted into trie.
- While inserting, we can keep track of the current maximum frequency and return that at the end as the answer.
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static TrieNode root;
    static Set<Character> set = new HashSet<>();

    // Complete the getMaxOccurrences function below.
    static int getMaxOccurrences(String s, int minLength, int maxLength, int maxUnique) {
        if(s == null || s.length() == 0)
            return 0;
        if(minLength < 0 || maxLength < 0 || maxUnique <= 0)
            return 0;
        
        int maxFreq = 0;
        root = new TrieNode();
        for(int i=0;i<s.length();i++){
            for(int j=minLength;j<=maxLength && j<=s.length(); ++j){
                String sub = s.substring(i, j);
                int currFreq = addToTrie(sub, maxUnique);
                if(currFreq == -1)
                    break;
                maxFreq = Math.max(maxFreq, currFreq);
            }
            minLength += 1;
            maxLength += 1;
        }
        return maxFreq;
    }

    private static int addToTrie(String word, int m){
        set.clear();
        TrieNode parent = root;
        for(char c : word.toCharArray()){
            set.add(c);
            if(set.size() > m){
                return -1;
            }
            int i = c - 'a';
            if(parent.next[i] == null){
                parent.next[i] = new TrieNode();
            }
            parent = parent.next[i];
        }
        if (parent.word != null) {
            parent.frequency += 1;
         } else {
             parent.word = word;
             parent.frequency = 1;
         }
         return parent.frequency;
    }


    static class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
        int frequency = 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int minLength = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int maxLength = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int maxUnique = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int res = getMaxOccurrences(s, minLength, maxLength, maxUnique);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
