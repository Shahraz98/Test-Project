package pack;

public class Euclid {

	public static void main(String[] args) {
		//	Enter p and q values:		
		int p = 11;
		int q = 33;
		//	Computing and printing GCD
		int gcd = gcd(p, q);
		System.out.println(gcd);
	}

	public static int gcd(int p, int q) {
		//	Computes GCD
		if (q == 0)
			return p;
		int r = p % q;
		return gcd(q, r);
	}
}