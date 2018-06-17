/*
Pascal's Triangle
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
1 6 15 20 15 6 1
....

Complete the function pascalTriangle, that has one parameter - an integer k. The function should print first k rows of Pascal's 
triangle, and the entries of a row must be printed separated by space.
2<=k<=25
*/

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        pascalTriangle(k);

        scanner.close();
    }
    
    /*
     * Complete the pascalTriangle function below.
     */
    static void pascalTriangle(int k) {
        /*
         * Write your code here.
         */
        if(k <= 0) return;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        result.add(pre);
        for(int i=2;i<=k;i++){
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            for(int j=0;j<pre.size() - 1;j++){
                curr.add(pre.get(j) + pre.get(j+1));
            }
            curr.add(1);
            result.add(curr);
            pre = curr;
        }
        for(ArrayList<Integer> sub : result){
            for(Integer element : sub){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
