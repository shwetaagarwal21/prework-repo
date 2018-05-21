public class Checkpoint2 {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        ArrayList<ArrayList<Integer>> lst = new ArrayList<ArrayList<Integer>>(A);
        int k =2*A-1;
        int [][]spiral = new int[k][k];
        int n=A, c1=0, c2=k-1, r1=0, r2=k-1;
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                spiral[i][j] = 0;
            }
        }
        
		while (n >= 1) {
			for (int i = c1; i <= c2; i++) {
				spiral[r1][i] = n;
			}
			for (int j = r1 + 1; j <= r2; j++) {
				spiral[j][c2] = n;
			}
			for (int i = c2 - 1; i >= c1; i--) {
				spiral[r2][i] = n;
			}
			for (int j = r2 - 1; j >= r1 + 1; j--) {
				spiral[j][c1] = n;
			}
			c1++;
			c2--;
			r1++;
			r2--;
			n--;
		}
		for (int i = 0; i < spiral.length; i++) {
			lst.add(new ArrayList<Integer>());
			for (int j = 0; j < spiral[0].length; j++) {
				lst.get(i).add(spiral[i][j]);
			}
	    }
		
        return lst;
    }
}
