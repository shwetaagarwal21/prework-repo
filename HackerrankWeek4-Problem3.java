/*
Counter Game

Louise and Richard have developed a numbers game. They pick a number and check to see if it is a power of . 
If it is, they divide it by . If not, they reduce it by the next lower number which is a power of . 
Whoever reduces the number to  wins the game. Louise always starts.

Given an initial value, determine who wins the game.

As an example, let the initial value n = 132. It's Louise's turn so she first determines that 132 is not a power of 2. 
The next lower power of 2 is 128, so she subtracts that from 132 and passes 4 to Richard. 4 is a power of 2, 
so Richard divides it by 2 and passes 2 to Louise. Likewise, 2 is a power so she divides it by 2 and reaches 1. 
She wins the game.

Update If they set counter to , Richard wins. Louise' cannot make a move so she loses.

Input Format

The first line contains an integer t, the number of testcases. 
Each of the next  lines contains an integer n, the initial value for the game.

Constraints
1<=t<=10
1<=n<=2^64 - 1

Output Format

For each test case, print the winner's name on a new line in the form Louise or Richard.

Sample Input 0

1
6
Sample Output 0

Richard
Explanation 0

6 is not a power of 2 so Louise reduces it by the largest power of 2 less than 6:6 - 4 = 2
2 is a power of 2 so Richard divides by 2 to get 1 and wins the game.

*/
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

/*
     * Complete the counterGame function below.
     */
    static void counterGame(String[] tests) {
        /*
         * Write your code here.
         */
        for(String test : tests){
            int num = Integer.parseInt(test);
            if(num == 1){
                System.out.println("Richard");
            }
            int original = num;
            while(num != 1){
                if(isPowerOf2(num)){
                    int div = num / 2;
                    num = div;
                    if(num == 1){
                        System.out.println("Richard");
                    }
                }else{
                    while(!isPowerOf2(num)){
                        if(num > 0)
                            num--;
                    }
                    int x = num & (num - 1);
                    num = num - x;
                    if(num == 1)
                        System.out.println("Louise");
                }
            }
        }
    }

    private static boolean isPowerOf2(int n){
        if(n<=0)
            return false;
        return Integer.bitCount(n) == 1;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        String[] tests = new String[testsCount];

        for (int testsItr = 0; testsItr < testsCount; testsItr++) {
            String testsItem = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
            tests[testsItr] = testsItem;
        }

        counterGame(tests);

        scanner.close();
    }
}
