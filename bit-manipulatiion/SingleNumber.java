/*
Single Number/Lonely Number

Given an array of integers, every element appears twice except for one. Find that single one.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example :

Input : [1 2 2 3 1]
Output : 3
*/

public int singleNumber(final List<Integer> A) {
        int result = 0;
        for(Integer a: A){
            result = result ^ a;
        }
        return result;
    }
