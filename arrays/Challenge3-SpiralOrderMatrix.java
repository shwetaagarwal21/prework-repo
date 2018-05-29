/*
Spiral Order
A matrix is a two-dimensional array of r rows, each with c columns, such that the total number of elements in the matrix is r * c.

The spiral order of such a matrix is the list of all its elements starting at index (0, 0) and proceeding in clockwise order from the outermost values to innermost values.

Write a program that takes an int[][] matrix as its input and returns an int[] of all the input's values in spiral order.

Example: Given the following matrix:

int[][] matrix = {
  { 1, 2, 3 },
  { 4, 5, 6 },
  { 7, 8, 9 }
};

Your program should return {1,2,3,6,9,8,7,4,5}
*/
public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int m = A.size();
        int n = A.get(0).size();
        int T = 0, B = m-1, L = 0, R = n-1;
        int dir = 0;
        while(L <=R && T <=B){
            if(dir == 0){
                for(int k=L;k<=R;k++)
                    result.add(A.get(T).get(k));
                T++;
            }
            else if(dir == 1){
                for(int k=T;k<=B;k++)
                    result.add(A.get(k).get(R));
                R--;
            }
            else if(dir == 2){
                for(int k=R;k>=L;k--)
                    result.add(A.get(B).get(k));
                B--;
            }
            else if(dir == 3){
                for(int k=B;k>=T;k--)
                    result.add(A.get(k).get(L));
                L++;
            }
            dir = (dir + 1)%4;
        }
        return result;
    }
