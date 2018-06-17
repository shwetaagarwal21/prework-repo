/* 
Is Possible
Consider a pair of integers, (a,b) We can perform the following operations on (a,b) in any order, zero or more times:
(a,b) -> (a+b,b)
(a,b) -> (a,a+b)
For example, you can start with (1,4), perform the operation (1+4,4) to get (5,4), perform the operation (5,5+4) to get (5,9) 
and perform the operation (5,5+9) to get (5,14). You could also start with (1,1+4) to get (1,5) and so on.
Complete the function isPossible below. The function must return a string denoting whether or not you can convert 
(a,b) to (c,d) by performing zero or more of the operations specified above. If it is possible, return the string Yes. Otherwise, return No.
1<=a,b,c,d<=1000
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

// Complete the isPossible function below.
    static String isPossible(int a, int b, int c, int d) {
        if(a == c && b == d) return "Yes";
        while(a < c && b < d){
            a = sum(a,b);
            if(a == c && sum(a,b) == d){
                return "Yes";
            }
        }
        while(a < d && b < c){
            b = sum(a,b);
            if(b == d && sum(a,b) == c){
                return "Yes";
            }
        }
        
        return "No";
    }

    static int sum(int a, int b){
        return a+b;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int a = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int b = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int c = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int d = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String res = isPossible(a, b, c, d);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

