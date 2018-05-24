/*
Substring Concatenation
You are given a string, S, and a list of words, L, that are all of the same length.
Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
Example :
S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).
*/


public class SubstringConcatenation {
	public ArrayList<Integer> findSubstring(String A, final List<String> B) {
	    
	    ArrayList<Integer> res = new ArrayList<>();
	    
	    if (A == null || B == null || B.size() == 0 || A.length() == 0)
	        return res;
	    
	    HashMap<String, Integer> words = new HashMap<>();
	    int len = 0;
	    
	    for (String str : B) {
	        int val = 1;
	        if (words.containsKey(str)) {
	            val = words.get(str) + 1;
	        }
	        words.put(str, val);
	        len = str.length();
	    }
	    
	    int size = B.size();
	    int index;
	    
	    for (int i = 0; i <= A.length() - len * size; i++) {
	        
	        index = i;
	        int loop = size;
	        HashMap<String, Integer> hashMap = new HashMap<>(words);
	        
	        for (int j = 0; j < loop; j++) {
	            String str = A.substring(index + j * len, index + j * len + len);
	            if (hashMap.containsKey(str)) {
	                int val = hashMap.get(str);
	                if (val == 1) {
	                    hashMap.remove(str);
	                } else {
	                    hashMap.put(str, val - 1);
	                }
	            } else {
	                break;
	            }
	        }
	        
	        if (hashMap.isEmpty()) {
	            res.add(i);
	        }
	        
	    }
	    
	    return res;
	    
	}
}

