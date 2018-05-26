import java.util.*;
import java.util.stream.Collectors;

public class LargestNumber {
    public class Node implements Comparable<Node> {
        int number;
        public Node(int num) {
            this.number = num;
        }
        
        @Override
        public int compareTo(Node that) {
            String first = String.valueOf(this.number) + String.valueOf(that.number);
            String second = String.valueOf(that.number) + String.valueOf(this.number);
            return second.compareTo(first);
        }                
    }
    
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        StringBuffer result = new StringBuffer();
        Node num[];
        int i =0;
        num = new Node[A.size()];
        
        for(int n : A) {
            num[i] = new Node(n);
            i++;
        }
        
        Arrays.sort(num);
        for(Node n : num) {
            if(n.number == 0 && result.length() != 0)
                continue;
            result.append(n.number);
        }
        return result.toString();
    }
    
}
