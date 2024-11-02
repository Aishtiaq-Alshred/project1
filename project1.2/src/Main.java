import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> results = new ArrayList<>();
        int lastResult = 0;

        do {
            System.out.println("Welcome, choose the operation you want :\n" +
                    "Enter 1 to addition the numbers\n" +
                    "Enter 2 to subtraction the numbers \n" +
                    "Enter 3 to multiplication the numbers\n" +
                    "Enter 4 to division the numbers\n" +
                    "Enter 5 to modulus the numbers\n" +
                    "Enter 6 to find maximum number\n" +
                    "Enter 7 to find minimum number\n" +
                    "Enter 8 to find the average of numbers\n" +
                    "Enter 9 to print the last result in calculator\n" +
                    "Enter 10 to print the list of all results in calculator");

            int choose = input.nextInt();

            if (choose >= 1 && choose <= 8) {
                System.out.println("Enter the first number:");
                int number1 = input.nextInt();
                System.out.println("Enter the second number:");
                int number2 = input.nextInt();

                switch (choose) {
                    case 1:
                        lastResult = number1 + number2;
                        System.out.println(number1 + " + " + number2 + " = " + lastResult);
                        break;
                    case 2:
                        lastResult = number1 - number2;
                        System.out.println(number1 + " - " + number2 + " = " + lastResult);
                        break;
                    case 3:
                        lastResult = number1 * number2;
                        System.out.println(number1 + " * " + number2 + " = " + lastResult);
                        break;
                    case 4:
                        if (number2 != 0) {
                            lastResult = number1 / number2;
                            System.out.println(number1 + " / " + number2 + " = " + lastResult);
                        } else {
                            System.out.println("Cannot divide by zero.");
                            continue;
                        }
                        break;
                    case 5:
                        lastResult = number1 % number2;
                        System.out.println(number1 + " % " + number2 + " = " + lastResult);
                        break;
                    case 6:
                        lastResult = Math.max(number1, number2);
                        System.out.println("The maximum number is: " + lastResult);
                        break;
                    case 7:
                        lastResult = Math.min(number1, number2);
                        System.out.println("The minimum number is: " + lastResult);
                        break;
                    case 8:
                        lastResult = (number1 + number2) / 2;
                        System.out.println("The average is: " + lastResult);
                        break;
                }
                results.add(lastResult);
            } else if (choose == 9) {
                System.out.println("The last result is: " + lastResult);
            } else if (choose == 10) {
                System.out.println("All results: " + results);
            } else {
                System.out.println("Invalid choice. Please choose a valid operation.");
            }

            System.out.println("Click Yes to continue the process and No to exit");
            input.nextLine();
        } while (input.nextLine().equalsIgnoreCase("yes"));
    }
}