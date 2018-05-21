public class Checkpoint3Part1 {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int kthsmallest(final List<Integer> A, int B) {
        int[] arr = new int[A.size()];
        int count = 0;
        for(Integer i : A){
            arr[count] = i;
            count++;
        }
        Arrays.sort(arr);
        return arr[B-1];
    }
}
