package TCPTahoeSimulation;

import java.util.Scanner;

public class TCPTahoeSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cwnd = 1;           // Congestion Window
        int ssthresh = 8;       // Slow Start Threshold
        int totalRounds = 20;   // Total time intervals (or "rounds")

        System.out.println("Simulating TCP Tahoe (cwnd, ssthresh):");

        for (int round = 1; round <= totalRounds; round++) {
            System.out.print("Round " + round + ": cwnd = " + cwnd);

            // Simulate packet loss
            if (simulatePacketLoss()) {
                System.out.println(" -> Packet loss detected!");
                ssthresh = cwnd / 2;
                cwnd = 1;
                System.out.println("          Reset cwnd to 1, new ssthresh = " + ssthresh);
            } else {
                if (cwnd < ssthresh) {
                    // Slow Start phase
                    cwnd *= 2;
                } else {
                    // Congestion Avoidance phase
                    cwnd += 1;
                }
            }
        }
    }

    // Random packet loss simulator (simulate a loss every few rounds)
    public static boolean simulatePacketLoss() {
        return Math.random() < 0.2;  // 20% chance of loss
    }
}
