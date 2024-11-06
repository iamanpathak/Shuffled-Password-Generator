import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class ShuffledPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.print("Enter the desired password length: ");
            int length = scanner.nextInt();

            System.out.print("Enter the number of uppercase letters: ");
            int uppercaseCount = scanner.nextInt();

            System.out.print("Enter the number of lowercase letters: ");
            int lowercaseCount = scanner.nextInt();

            System.out.print("Enter the number of special characters: ");
            int specialCharCount = scanner.nextInt();

            System.out.print("Enter the number of digits: ");
            int digitCount = scanner.nextInt();

            // Validate input
            int totalCharacters = uppercaseCount + lowercaseCount + specialCharCount + digitCount;
            if (totalCharacters != length) {
                System.out.println("Error: The total character count must match the desired password length.");
                continue;
            }

            // Generate the password
            StringBuilder password = new StringBuilder();
            for (int i = 0; i < uppercaseCount; i++) {
                password.append((char) (random.nextInt(26) + 'A'));
            }
            for (int i = 0; i < lowercaseCount; i++) {
                password.append((char) (random.nextInt(26) + 'a'));
            }
            for (int i = 0; i < specialCharCount; i++) {
                String specialChars = "!@#$%^&*()_+{}[]:;<>,.?/";
                password.append(specialChars.charAt(random.nextInt(specialChars.length())));
            }
            for (int i = 0; i < digitCount; i++) {
                password.append(random.nextInt(10));
            }

            // Shuffle the password
            ArrayList<Character> passwordList = new ArrayList<>();
            for (char c : password.toString().toCharArray()) {
                passwordList.add(c);
            }
            Collections.shuffle(passwordList);
            StringBuilder shuffledPassword = new StringBuilder();
            for (char c : passwordList) {
                shuffledPassword.append(c);
            }

            System.out.println("Generated password (shuffled): " + shuffledPassword.toString());

            // Ask for feedback
            System.out.print("Would you like to provide feedback? (YES/NO): ");
            String feedbackResponse = scanner.next().toUpperCase();
            if (feedbackResponse.equals("YES")) {
                System.out.print("Please enter your feedback: ");
                scanner.nextLine(); // Consume newline
                String feedback = scanner.nextLine();
                System.out.println("Thank you for your feedback: " + feedback);
            } else {
                break;
            }
        }

        System.out.println("Thank you for using the password generator!");
    }
}
