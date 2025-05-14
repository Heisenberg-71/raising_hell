import java.util.regex.*;

public class RegexDemo {
    public static void main(String[] args) {

        // 2. Finding multiple matches
        String numbers = "My numbers are 123, 456, and 789";
        Pattern digitPattern = Pattern.compile("\\d+");
        Matcher matcher = digitPattern.matcher(numbers);

        System.out.println("\nNumbers found:");
        while(matcher.find()) {
            System.out.println(matcher.group());
        }



        // 4. Replacing text
        String sentence = "The price is $10.50 and $20.00";
        String replaced = sentence.replaceAll("\\$\\d+\\.\\d{2}", "[price]");
        System.out.println("\nReplaced sentence: " + replaced);

        // 5. Email validation
        String email = "test@example.com";
        boolean isValidEmail = email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        System.out.println("\nIs '" + email + "' a valid email? " + isValidEmail);
    }
}