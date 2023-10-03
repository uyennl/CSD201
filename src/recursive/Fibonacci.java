package recursive;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 50; // Số phần tử trong dãy Fibonacci cần tính
        System.out.println("Dãy Fibonacci gồm " + n + " phần tử:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}