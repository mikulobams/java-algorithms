package Fibonacci;

import java.util.HashMap;

/**
 * Fibonacci class
 */
public class Fibonacci {
    private static HashMap<Integer, Integer> memo = new HashMap<>();

    /**
     * Calculate the nth Fibonacci number using memoization
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n <= 1) {
            return n;
        }

        int result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);

        return result;
    }
}
