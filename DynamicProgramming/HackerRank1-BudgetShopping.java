/*
Budget Shopping
Given n as total budget you have, cost as the each bundle of notebook cost in ith store, 
quantity as number of notebooks in each bundle you have in ith store. Each store have unlimited bundle of notebooks.
Return the maximum number of notebook you can buy in n budget
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the budgetShopping function below.
    static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts) {
        if(n <=0 || bundleQuantities == null || bundleQuantities.length == 0 || bundleCosts == null || bundleCosts.length == 0)
            return 0;
        int maxCount[] = new int[]{0};
        dfs(n, bundleQuantities, bundleCosts, 0, 0, maxCount);
        return maxCount[0];
    }

    private static void dfs(int n, int[] bundleQuantities, int[] bundleCosts, int index, int count, int[] maxCount){
        if(n == 0 || index == bundleCosts.length){
            maxCount[0] = Math.max(maxCount[0], count);
            return ;
        }
        
        for(int i=0; i<= n/bundleCosts[index];i++){
            dfs(n-i*bundleCosts[index], bundleQuantities, bundleCosts, index+1, count + i*bundleQuantities[index], maxCount);
        }
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int bundleQuantitiesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] bundleQuantities = new int[bundleQuantitiesCount];

        for (int i = 0; i < bundleQuantitiesCount; i++) {
            int bundleQuantitiesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            bundleQuantities[i] = bundleQuantitiesItem;
        }

        int bundleCostsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] bundleCosts = new int[bundleCostsCount];

        for (int i = 0; i < bundleCostsCount; i++) {
            int bundleCostsItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            bundleCosts[i] = bundleCostsItem;
        }

        int res = budgetShopping(n, bundleQuantities, bundleCosts);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

