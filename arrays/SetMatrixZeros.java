/*
Set Matrix Zeros
Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.

Do it in place.

Example

Given array A as

1 0 1
1 1 1 
1 1 1

On returning, the array A should be :

0 0 0
1 0 1
1 0 1

*/
public class Solution {
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
	    boolean rowFlag = false;
	    boolean colFlag = false;
	    for(int i=0; i<a.size();i++){
	        for(int j=0; j<a.get(0).size();j++){
	            if(i == 0 && a.get(i).get(j) == 0)
	                rowFlag = true;
	            if(j == 0 && a.get(i).get(j) == 0)
	                colFlag = true;
	            if(a.get(i).get(j) == 0){
	                a.get(0).set(j, 0);
	                a.get(i).set(0, 0);
	            }
	        }
	    }
	    
	    for (int i = 1; i < a.size(); i ++){
	       for(int j=1; j<a.get(0).size();j++){
	           if(a.get(0).get(j) == 0 || a.get(i).get(0) == 0){
	               a.get(i).set(j, 0);
	           }
	       }
	    }
	    
	    if(rowFlag){
	        for(int i=0; i<a.get(0).size();i++){
	            a.get(0).set(i, 0);
	        }
	    }
	    
	    if(colFlag){
	        for(int j=0; j<a.size();j++){
	            a.get(j).set(0, 0);
	        }
	    }
	}
}
