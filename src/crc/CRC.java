package crc;

import java.util.Scanner;

public class CRC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input Data
        System.out.print("Enter the data bits: ");
        String data = sc.nextLine();

        System.out.print("Enter the divisor (generator polynomial): ");
        String divisor = sc.nextLine();

        // Append zeros to data
        String dividend = data + "0".repeat(divisor.length() - 1);

        // Sender Side CRC calculation
        String remainder = divide(dividend, divisor);
        String codeword = data + remainder;

        System.out.println("Transmitted Codeword: " + codeword);

        // Receiver Side
        System.out.print("\nEnter the received codeword: ");
        String received = sc.nextLine();

        String receivedRemainder = divide(received, divisor);

        if (receivedRemainder.contains("1")) {
            System.out.println("Error detected in the received data.");
        } else {
            System.out.println("No error detected.");
        }
    }

    // Performs Modulo-2 division
    public static String divide(String dividend, String divisor) {
        int len = divisor.length();
        String temp = dividend.substring(0, len);

        for (int i = len; i < dividend.length(); i++) {
            if (temp.charAt(0) == '1') {
                temp = xor(temp, divisor) + dividend.charAt(i);
            } else {
                temp = xor(temp, "0".repeat(len)) + dividend.charAt(i);
            }
            temp = temp.substring(1);
        }

        // Final step
        if (temp.charAt(0) == '1') {
            temp = xor(temp, divisor);
        } else {
            temp = xor(temp, "0".repeat(len));
        }

        return temp.substring(1);
    }

    // XOR between two binary strings
    public static String xor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            result.append(a.charAt(i) == b.charAt(i) ? '0' : '1');
        }
        return result.toString();
    }
}
