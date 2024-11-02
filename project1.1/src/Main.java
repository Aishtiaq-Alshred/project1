import java.util.Random;
import java.util.Scanner;
//لعبه اكس او
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        //جربت انسخ ملصقات واحطها ضبطت معي وحبيت شكلها عشان كذا ما مسحتها
        System.out.println("Welcome to the game tic tac toe \uD83C\uDFAE");

        // الحرف اللي يبي يلعب فيه اليوزر
        System.out.println("Choose your letter (X or O):");
        String playerChoice = input.nextLine().toUpperCase();
        while (!playerChoice.equals("X") && !playerChoice.equals("O")) {
            System.out.println("Invalid choice. Please choose either X or O:");
            playerChoice = input.nextLine().toUpperCase();
        }

        String computerChoice;
        if (playerChoice.equals("X")) {
            computerChoice = "O";
        } else {
            computerChoice = "X";
        }


        // يختار اليوز كم مره يبي يلعب
        System.out.println("Choose an option:");
        System.out.println("1 - Play one round");
        System.out.println("2 - Play 3 rounds and then determine the winner");

        int choice = input.nextInt();
        input.nextLine(); //لتجنب مشكلة السطر الفارغ `

        int playerWins = 0;
        int computerWins = 0;

        int roundsToPlay;
        if (choice == 2) {
            roundsToPlay = 3;
        } else {
            roundsToPlay = 1;
        }

        for (int round = 1; round <= roundsToPlay; round++) {
            System.out.println("Starting round " + round);


            String[][] array = new String[3][3];
            initializeGame(array);

            // بدء اللعبة
            while (true) {
                displayGame(array);

                playerMove(input, array, playerChoice);
                if (checkWinner(array, playerChoice)) {
                    System.out.println("Congratulations, you won this round! \uD83D\uDE0E");
                    playerWins++;
                    break;
                }

                displayGame(array);

                computerMove(array, random, computerChoice);
                if (checkWinner(array, computerChoice)) {
                    System.out.println("Computer wins this round. Better luck next time!");
                    computerWins++;
                    break;
                }
            }

            displayGame(array);
        }

        //  النتيجة النهائية
        if (roundsToPlay == 3) {
            System.out.println("Final results after 3 rounds:");
            System.out.println("Player wins: " + playerWins);
            System.out.println("Computer wins: " + computerWins);

            if (playerWins > computerWins) {
                System.out.println("Congratulations! You are the overall winner.\uD83D\uDE0E");
            } else if (computerWins > playerWins) {
                System.out.println("The computer is the overall winner. Better luck next time!\uD83D\uDC7B");
            } else {
                System.out.println("It's a tie after 3 rounds!\uD83E\uDD17");
            }
        } else {
            System.out.println("Thank you for playing one round of tic tac toe!\uD83D\uDE0A");
        }
    }

    // مصفوفة بقيم مبدئية
    public static void initializeGame(String[][] array) {
        int value = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = String.valueOf(value);
                value++;
            }
        }
    }

    public static void displayGame(String[][] array) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    public static void playerMove(Scanner input, String[][] array, String playerChoice) {
        int playerMove;
        while (true) {
            System.out.println("Choose your location (1-9):");
            playerMove = input.nextInt();
            input.nextLine(); // لتجنب مشكلة السطر الفاضي

            int row = (playerMove - 1) / 3;
            int col = (playerMove - 1) % 3;

            // يتأكد من أن المكان فاضي
            if (!array[row][col].equals("X") && !array[row][col].equals("O")) {
                array[row][col] = playerChoice;
                break;
            } else {
                System.out.println("This location is already occupied. Try again.");
            }
        }
    }


    public static void computerMove(String[][] array, Random random, String computerChoice) {
        int computerMove;
        while (true) {
            //معناته ان الاختيار العشوائي بيكون 1الى 9
            computerMove = random.nextInt(9)+1 ;
            int row = (computerMove - 1) / 3;
            int col = (computerMove - 1) % 3;


            if (!array[row][col].equals("X") && !array[row][col].equals("O")) {
                array[row][col] = computerChoice;
                System.out.println("Computer chose position: " + computerMove);
                break;
            }
        }
    }


    public static boolean checkWinner(String[][] array, String player) {
        //  تتأكد من اكتمال صفوف الفوز
        for (int i = 0; i < 3; i++) {
            if (array[i][0].equals(player) && array[i][1].equals(player) && array[i][2].equals(player)) {
                return true;
            }
        }
        //  من الأعمدة
        for (int i = 0; i < 3; i++) {
            if (array[0][i].equals(player) && array[1][i].equals(player) && array[2][i].equals(player)) {
                return true;
            }
        }
        //  من الأقطار
        if (array[0][0].equals(player) && array[1][1].equals(player) && array[2][2].equals(player)) {
            return true;
        }
        if (array[0][2].equals(player) && array[1][1].equals(player) && array[2][0].equals(player)) {
            return true;
        }

        return false;
    }
}
