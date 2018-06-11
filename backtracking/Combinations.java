/*
Combinations
Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,

    Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
    Entries should be sorted within themselves.

Example :
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]

*/

public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        int n = A, k = B;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
 
        if (n <= 0 || n < k)
            return result;
 
        ArrayList<Integer> item = new ArrayList<Integer>();
        dfs(n, k, 1, item, result); // because it need to begin from 1
 
        return result;
    }
    
    void dfs(int n, int k, int start, ArrayList<Integer> item,
        ArrayList<ArrayList<Integer>> res) {
        if (item.size() == k) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
 
        for (int i = start; i <= n; i++) {
            item.add(i);
            dfs(n, k, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }
    
    
