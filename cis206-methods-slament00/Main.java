import java.util.Random;
import java.util.Scanner;

public class P5_08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter words: ");

        while (!input.hasNext("EXIT!")) {
            String word = input.next();
            System.out.println(scramble(word));
        }

        input.close();
    }

    public static String scramble(String word) {
        if (word.length() > 3) {
            Random random = new Random();
            int firstIndex = random.nextInt(word.length() - 1) + 1;
            int secondIndex = random.nextInt(word.length() - 1) + 1;

            if (firstIndex == secondIndex) {
                while (firstIndex == secondIndex) {
                    secondIndex = random.nextInt(word.length() - 1) + 1;
                }
            }

            if (firstIndex > secondIndex) {
                return word.substring(0, secondIndex) +
                       word.charAt(firstIndex) +
                       word.substring(secondIndex + 1, firstIndex) +
                       word.charAt(secondIndex) +
                       word.substring(firstIndex + 1);
            } else {
                return word.substring(0, firstIndex) +
                       word.charAt(secondIndex) +
                       word.substring(firstIndex + 1, secondIndex) +
                       word.charAt(firstIndex) +
                       word.substring(secondIndex + 1);
            }
        } else {
            return word;
        }
    }
}
