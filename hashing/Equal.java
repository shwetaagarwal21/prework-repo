/*
Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array
Note:
1) Return the indices `A1 B1 C1 D1`, so that 
  A[A1] + A[B1] = A[C1] + A[D1]
  A1 < B1, C1 < D1
  A1 < C1, B1 != D1, B1 != C1 

2) If there are more than one solutions, 
   then return the tuple of values which are lexicographical smallest. 

Assume we have two solutions
S1 : A1 B1 C1 D1 ( these are values of indices int the array )  
S2 : A2 B2 C2 D2

S1 is lexicographically smaller than S2 iff
  A1 < A2 OR
  A1 = A2 AND B1 < B2 OR
  A1 = A2 AND B1 = B2 AND C1 < C2 OR 
  A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2

Example:
Input: [3, 4, 7, 1, 2, 9, 8]
Output: [0, 2, 3, 5] (O index)
*/
public class Equal {
    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = A.size();
        ArrayList<Integer> list;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int sum = A.get(i) + A.get(j);
                if(!map.containsKey(sum)){
                    list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    map.put(sum, list);
                } else {
                    list = map.get(sum);
                    list.add(i);
                    list.add(j);
                    map.put(sum, list);
                }
            }
        }
        
        //System.out.println("map.size() :::: " + map.size());
        List<String> listString = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
        	ArrayList<Integer> ll = entry.getValue();
        	//listString = new ArrayList<>();
        	if(ll.size() >= 4) {
	        	StringBuffer sb = new StringBuffer();
	        	for(Integer x : ll) {
	        		sb.append(x);
	        	}
	        	//System.out.println("sb.toString():::: " + sb.toString());
	        	listString.add(sb.toString());
        	}
        }
        
        String ss = listString.stream().min(Comparator.comparing(String::valueOf)).get();
        //System.out.println("ss is ::: " + ss);
        
        char[] cc = ss.toCharArray();
        int count = 0;
        for(char c : cc) {
        	if(count < 4) {
        		result.add(new Integer(String.valueOf(c)));
        		count++;
        	}
        }
        
        return result;
    }
}
