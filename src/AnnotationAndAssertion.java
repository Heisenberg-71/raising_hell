/**
 * A simple program to demonstrate Javadoc and assertions.
 * <p>
 * This class checks if a person is eligible to vote based on age.
 * </p>
 *
 * @author YourName
 * @version 1.0
 */
public class AnnotationAndAssertion {

    /**
     * Checks voting eligibility using assertions.
     *
     * @param age the age to check (must be positive)
     * @throws AssertionError if age is less than 18
     */
    public static void checkEligibility(int age) {
        // Assertion to validate voting age
        assert age > 0 : "Age must be positive";
        assert age >= 18 : "Person is not eligible to vote";

        System.out.println("Person (age: " + age + ") is eligible to vote.");
    }

    /**
     * Main method to demonstrate the functionality.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Test cases
        checkEligibility(20);  // Will pass assertion
        checkEligibility(15);  // Will fail assertion

        // Uncomment to test negative age
        // checkEligibility(-5);  // Will fail first assertion
    }
}