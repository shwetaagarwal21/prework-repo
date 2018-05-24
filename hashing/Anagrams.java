/*
Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.
    Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp' 
    Note: All inputs will be in lower-case. 
Example :
Input : cat dog god tca
Output : [[1, 4], [2, 3]]
*/
public class Anagrams {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> list;
        char[] chrArray;
        int i = 1;
        for(String str : A){
            chrArray = str.toLowerCase().toCharArray();
            Arrays.sort(chrArray);
            if(map.containsKey(new String(chrArray))){
            	list = map.get(new String(chrArray));
            	list.add(i);
                map.put(new String(chrArray), list);
            } else {
            	list = new ArrayList<>();
            	list.add(i);
                map.put(new String(chrArray), list);
            }
            i++;
        }
        ArrayList<ArrayList<Integer>> a1 = new ArrayList<>();
        ArrayList<Integer> a2;
        List<Integer> ll = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
        	String key = entry.getKey();
        	List<Integer> value = entry.getValue();
        	a2 = new ArrayList<>();
        	for(Integer a : value){
        		a2.add(a);
        	}
        	a1.add(a2);
        }
        return a1;
    }
}
