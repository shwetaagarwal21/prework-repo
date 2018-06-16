/*
Black Shapes


Given N * M field of O's and X's, where O=white, X=black
Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

Example:

OOOXOOO
OOXXOXO
OXOOOXO

answer is 3 shapes are  :
(i)    X
     X X
(ii)
      X
 (iii)
      X
      X

Note that we are looking for connected shapes here.

For example,

XXX
XXX
XXX

is just one single connected black shape.

Approach: 
Iterate over the 2D array and if the current element is 'X' start a dfs traversal over 4 possible directions - 
{i+1, j} {i-1, j}, {i, j+1}, {i, j-1}. We need to keep a track of these nodes by marking them some how so that next we 
encounter them, we do not start counting them again. For this I am using a visited[][] array. 
The result will be the total numbers of DFS traversals.
*/

public class Solution {
    public int black(ArrayList<String> A) {
        if(A.size() == 0) return 0;
        int[][] arr = getArrayWithZeroAndOne(A);
        return solve(arr, A.size(), A.get(0).length());
    }
    
    private int solve(int[][] arr, int r, int c){
        boolean[][] visited = new boolean[r][c];
        int count = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    dfs(arr, i, j, visited, r, c);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(int[][] arr, int i, int j, boolean[][] visited, int r, int c){
        if(i < 0 || i > r - 1)
            return;
        if(j < 0 || j > c - 1)
            return;
        if(arr[i][j] == 0 || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        dfs(arr, i+1, j, visited, r, c);
        dfs(arr, i-1, j, visited, r, c);
        dfs(arr, i, j+1, visited, r, c);
        dfs(arr, i, j-1, visited, r, c);
    }
    
    private int[][] getArrayWithZeroAndOne(ArrayList<String> A){
        int[][] arr = new int[A.size()][A.get(0).length()];
        int i = 0;
        for(String str : A){
            for(int j=0;j<str.length();j++){
                arr[i][j] = 0;
                if(str.charAt(j) == 'X')
                    arr[i][j] = 1;
            }
            i++;
        }
        return arr;
    }
}
