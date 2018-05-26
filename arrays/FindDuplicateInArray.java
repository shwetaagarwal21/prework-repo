/*Find Duplicate in Array
*/
public class FindDuplicateInArray {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	    Set set = new HashSet();
	    for(Integer i : a){
	        if(set.add(i) == false)
	            return i;
	    }
	    return -1;
	}
}
