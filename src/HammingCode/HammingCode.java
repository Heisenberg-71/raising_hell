package HammingCode;

import java.util.Scanner;

public class HammingCode {

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input 4 data bits
        int[] data = new int[4];
        System.out.println("Enter 4 data bits (only 0 or 1):");
        for (int i = 0; i < 4; i++) {
            data[i] = sc.nextInt();
        }

        // Step 2: Calculate parity bits and construct the 7-bit Hamming code
        int[] hammingCode = new int[7];
        hammingCode[2] = data[0]; // d1
        hammingCode[4] = data[1]; // d2
        hammingCode[5] = data[2]; // d3
        hammingCode[6] = data[3]; // d4

        // Calculate parity bits (even parity)
        hammingCode[0] = hammingCode[2] ^ hammingCode[4] ^ hammingCode[6]; // p1
        hammingCode[1] = hammingCode[2] ^ hammingCode[5] ^ hammingCode[6]; // p2
        hammingCode[3] = hammingCode[4] ^ hammingCode[5] ^ hammingCode[6]; // p4

        System.out.print("Hamming Code generated: ");
        for (int bit : hammingCode) {
            System.out.print(bit);
        }

        // Step 3: Introduce an error
        System.out.print("\nEnter position to flip (0 for no error): ");
        int errorPos = sc.nextInt();
        if (errorPos > 0 && errorPos <= 7) {
            hammingCode[errorPos - 1] ^= 1; // Flip the bit
            System.out.print("Received code with error: ");
            for (int bit : hammingCode) {
                System.out.print(bit);
            }
        }

        // Step 4: Error detection and correction
        int p1 = hammingCode[0] ^ hammingCode[2] ^ hammingCode[4] ^ hammingCode[6];
        int p2 = hammingCode[1] ^ hammingCode[2] ^ hammingCode[5] ^ hammingCode[6];
        int p4 = hammingCode[3] ^ hammingCode[4] ^ hammingCode[5] ^ hammingCode[6];

        int errorLocation = p4 * 4 + p2 * 2 + p1;

        if (errorLocation == 0) {
            System.out.println("\nNo error detected.");
        } else {
            System.out.println("\nError detected at position: " + errorLocation);
            hammingCode[errorLocation - 1] ^= 1; // Correct the error
            System.out.print("Corrected Hamming code: ");
            for (int bit : hammingCode) {
                System.out.print(bit);
            }
        }
    }
}
