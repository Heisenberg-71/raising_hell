public class PrimeCheck {

    // Brute-force prime check (O(n))
    public static boolean isPrimeBruteForce(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Optimized brute-force (check up to √n) (O(√n))
    public static boolean isPrimeOptimized(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int number = 29;

        if (isPrimeBruteForce(number)) {
            System.out.println(number + " is a prime number (Brute-Force)");
        } else {
            System.out.println(number + " is not a prime number (Brute-Force)");
        }

        if (isPrimeOptimized(number)) {
            System.out.println(number + " is a prime number (Optimized)");
        } else {
            System.out.println(number + " is not a prime number (Optimized)");
        }
    }
}