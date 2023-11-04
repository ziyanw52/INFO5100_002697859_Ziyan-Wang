package exercises.exercise4;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegularExpression {

    public static void main(String[] args) {
        // Regular expressions
        String regex1 = "^\\d+$"; // All digits
        String regex2 = "^[A-Z][a-z]+ [A-Z][a-z]+$"; // Full name
        String regex3 = "(0[1-9]|1[0-2])/(0[1-9]|[12]\\d|3[01])/\\d{4}"; // MM/DD/YYYY
        String regex4 = "\\b[\\w.%+-]+@northeastern\\.edu\\b"; // NEU Email addresses
        String regex5 = "^\\d{5}(-\\d{4})?$"; // zipcode

        // Test cases
        String input1 = "123456789";
        String input2 = "Jackson Lee";
        String input3 = "11/01/2023";
        String input4 = "jennyliu@northeastern.edu";
        String input5 = "95113";

        // Positive cases
        testPatternMatch("Positive Case 1 (Digits):", regex1, input1);
        testPatternMatch("Positive Case 2 (Name):", regex2, input2);
        testPatternMatch("Positive Case 3 (Date):", regex3, input3);
        testPatternMatch("Positive Case 4 (Email):", regex4, input4);
        testPatternMatch("Positive Case 5 (Zipcode):", regex5, input5);

        // Negative cases
        testPatternUnmatch("Negative Case 1 (Digits):", regex1, "123ABC");
        testPatternUnmatch("Negative Case 2 (Name):", regex2, "jack");
        testPatternUnmatch("Negative Case 3 (Date):", regex3, "2023/11/01");
        testPatternUnmatch("Negative Case 4 (Email):", regex4, "mike@gmail.com");
        testPatternUnmatch("Negative Case 5 (Zipcode):", regex5, "123");
    }

    private static void testPatternMatch(String description, String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            System.out.println(description + " Matched: " + input);
        } else {
            System.out.println(description + " Not Matched: " + input);
        }
    }

    private static void testPatternUnmatch(String description, String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.find()) {
            System.out.println(description + " Not Matched: " + input);
        } else {
            System.out.println(description + " Matched: " + input);
        }
    }
}

