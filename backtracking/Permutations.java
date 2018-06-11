/*
Permutations
Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3] 
[2,3,1] 
[3,1,2] 
[3,2,1]

    NOTE

        No two entries in the permutation sequence should be the same.
        For the purpose of this problem, assume that all the numbers in the collection are unique.

*/

public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        permute(A, 0, result);
        return result;
    }
    
    void permute(ArrayList<Integer> A, int start, ArrayList<ArrayList<Integer>> res){
        if(start >= A.size()){
            res.add(new ArrayList<Integer>(A));
        }
        
        for(int j=start; j<= A.size()-1; j++){
            swap(A, start, j);
            permute(A, start+1, res);
            swap(A, start, j);
        }
            
    }
    
    void swap(ArrayList<Integer> A, int i, int j){
        int t = A.get(i);
        A.set(i, A.get(j));
        A.set(j, t);
    }
    
    
