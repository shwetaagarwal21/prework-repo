/*
Enumerate all primes <= n
A prime number (or a prime) is an integer greater than 1 that has no positive divisors other than 1 and itself.

Write a program which takes as input an int value n and returns an array of int containing all unique primes <= n.

Example: if the value of n is 8, the function should return: {2,3,5,7}

Hint: One well-known algorithm for doing this is over 2,000 years old, but it's not the most efficient.

Remember, you are not allowed to use any primality testing functions.
*/
ArrayList<Integer> retrievePrimesLessThanN(int n) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=2;i<=n;i++) {
			if(isPrime(i))
				al.add(i);
		}
		return al;
	}
	
	boolean isPrime(int n) {
		for(int i=2;i<n;i++) {
			if(n%i == 0)
				return false;
		}
		return true;
	}
