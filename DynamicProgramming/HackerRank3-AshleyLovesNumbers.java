/*
Ashley Loves Numbers
Ashley loves numbers made up of unique digits. She is less enchanted with numbers that have repeating digits. Given a range of 
integers, determine how many numbers she will love. 
For example, the lower bound n=80 and upper bound m=120. Both are inclusive, so there are 120-79 = 41 values in the range. 
Numbers she love are unique digits. There are 27 numbers she loves and 14 other numbers in the range. 
Complete the function countNumbers below.

*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countNumbers function below.
    static void countNumbers(int[][] arr) {
        if(arr == null || arr.length == 0) 
            return ;
        
        int[] love = new int[arr.length];
        int count = 0;
        for(int row=0;row<arr.length;row++){
            love[row] = countUniqueNumbersInRange(arr[row][0], arr[row][1]);
        }
    }

    private static int countUniqueNumbersInRange(int l, int r){
        int count = 0;
        for(int i=l;i<=r;i++){
            int num = i;
            boolean visited[] = new boolean[10];
            while(num != 0){
                if(visited[num % 10])
                    break;
                visited[num % 10] = true;
                num = num/10;
            }
            if(num == 0)
                count += 1;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int arrRows = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int arrColumns = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] arr = new int[arrRows][arrColumns];

        for (int i = 0; i < arrRows; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < arrColumns; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        countNumbers(arr);

        scanner.close();
    }
}
