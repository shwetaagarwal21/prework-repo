/*
Sum Of Fibonacci Numbers

How many minimum numbers from fibonacci series are required such that sum of numbers should be equal to a given Number N?
Note : repetition of number is allowed.

Example:

N = 4
Fibonacci numbers : 1 1 2 3 5 .... so on
here 2 + 2 = 4 
so minimum numbers will be 2 

*/
public class Solution {
    public int fibsum(int A) {
        List<Integer> fibs = getFibNums(A);
        int count = 0;
        int index = fibs.size() - 1;
        while(A > 0){
            if (A >= fibs.get(index)) {
                count += A / fibs.get(index);
                A %= fibs.get(index);
            }
            index--;
        }
        return count;
    }
    
    private List<Integer> getFibNums(int A){
        List<Integer> fibs = new ArrayList<Integer>();
        fibs.add(1);
        fibs.add(1);
        while(fibs.get(fibs.size() - 1) < A){
            fibs.add(fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2));
        }
        return fibs;
    }
}
