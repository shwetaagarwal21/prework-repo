/*
Best Time to Buy and Sell Stocks I

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example :

Input : [1 2]
Return :  1


*/
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        if(A == null || A.size() == 0)
            return 0;
        
        int min = A.get(0);
        int result = 0;
        for(int i=1;i<A.size();i++){
            result = Math.max(result, A.get(i) - min);
            min = Math.min(min, A.get(i));
        }
        return result;
    }
}
