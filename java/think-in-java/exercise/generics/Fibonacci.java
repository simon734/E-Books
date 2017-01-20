import simon.util.*;
public class Fibonacci implements Generator<Integer> {
	private int count = 0;
	public Integer next() { return fib(count++); }
	private int fib(int n) {
		if (n < 2 ) {
			return 1;
		}
		return fib(n-2) + fib(n-1);
	}
	public static void main(String[] args) {
		Fibonacci gen = new Fibonacci();
		for (int i = 0, num = 1; i < 100; i++, num++) {
			System.out.print(gen.next() + " ");
			if (num % 10 == 0) {
				System.out.println();
			}
		}
	}
}